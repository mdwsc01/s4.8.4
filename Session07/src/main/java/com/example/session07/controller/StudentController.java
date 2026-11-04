package com.example.session07.controller;

import com.example.session07.dto.StudentDTO;
import com.example.session07.dto.StudentResponse;
import com.example.session07.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.data.mapping.callback.ReactiveEntityCallbacks;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok("Thêm sinh viên thành công");
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable String id) {
        StudentResponse student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

}
