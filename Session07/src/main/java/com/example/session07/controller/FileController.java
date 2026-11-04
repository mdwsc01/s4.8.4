package com.example.session07.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Locale;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "image",required = false) MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("File không hợp lệ");
        }

        String fileName = file.getOriginalFilename();

        if (fileName == null || fileName.isBlank()) {
            return ResponseEntity.badRequest().body("File không hợp lệ");
        }

        if (!fileName.equals(Paths.get(fileName).getFileName().toString()) ||
                fileName.contains("\\") ||
                fileName.equals(".") ||
                fileName.equals("..")) {
            return ResponseEntity.badRequest().body("Tên file không hợp lệ");
        }

        String lowerName = fileName.toLowerCase(Locale.ROOT);

        if (!(lowerName.endsWith(".jpg") ||
                lowerName.endsWith(".jpeg") ||
                lowerName.endsWith(".png"))) {
            return ResponseEntity.badRequest().body("Chỉ chấp nhận file JPG hoặc PNG");
        }

        String contentType = file.getContentType();

        boolean validMime = (lowerName.endsWith(".jpg") && "image/jpeg".equals(contentType)) || lowerName.endsWith(".png") && "image/png".equals(contentType);
        if(!validMime) {
            return ResponseEntity.badRequest().body("Định dạng ảnh không hợp lệ");
        }

        if(file.getSize() > 1024 * 1024){
            return ResponseEntity.status(413).body("File quá lớn(tối đa 1MB!)");
        }

        Path uploadPath = Paths.get(uploadDir)
                .toAbsolutePath().normalize();

        Files.createDirectories(uploadPath);

        Path filePath = uploadPath.resolve(lowerName).normalize();

        if(!filePath.getParent().equals(uploadPath)) {
            return ResponseEntity.badRequest().body("Tên file không hợp lệ");
        }

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }

        return ResponseEntity.ok("Upload thành công file: " + fileName);

    }
}
