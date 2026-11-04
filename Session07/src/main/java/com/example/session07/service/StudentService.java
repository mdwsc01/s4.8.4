package com.example.session07.service;

import com.example.session07.dto.StudentResponse;
import com.example.session07.exception.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final List<StudentResponse> students = List.of(
            new StudentResponse("SV001","Nguyễn Văn A"),
            new StudentResponse("SV002","Trần Thị B"),
            new StudentResponse("SV003","Lê Văn C")
    );

    public StudentResponse getStudentById(String id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst().orElseThrow(()-> new StudentNotFoundException("Sinh viên với ID: "+ id + "không tồn tại"));
    }
}
