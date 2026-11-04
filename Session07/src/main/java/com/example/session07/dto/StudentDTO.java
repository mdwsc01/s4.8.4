package com.example.session07.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class StudentDTO {
    @NotBlank(message = "Họ và tên không được để trống")
    @Size(min = 5,max = 100,message = "Họ và tên phải từ 5-100 kí tự")
    private String fullName;

    @NotBlank(message = "Chuyên ngành không được để trống")
    private String major;

    @NotNull(message = "Tuổi không được để trống")
    @Min(value = 18, message = "Tuổi phải từ 18 tuổi trở lên")
    private Integer age;

    @NotNull(message = "Điểm GPA không được để trống")
    @Min(value = 0, message = "GPA không được nhỏ hơn 0")
    @Max(value = 10, message = "GPA không được lớn hơn 10")
    private Double gpa;

    @NotBlank(message = "Mã sinh viên không được để trống")
    @Pattern(
            regexp = "^SV\\d{4}$",
            message = "Mã sinh viên bắt đầu bằng SV và có đúng 4 chữ số"
    )
    private String studentCode;

    @NotNull(message = "Thông tin phụ huynh không được để trống")
    @Valid
    private ParentDTO parent;

    public ParentDTO getParent() {
        return parent;
    }

    public void setParent(ParentDTO parent) {
        this.parent = parent;
    }

    public StudentDTO(String fullName, String major, Integer age, Double gpa, String studentCode, ParentDTO parent) {
        this.fullName = fullName;
        this.major = major;
        this.age = age;
        this.gpa = gpa;
        this.studentCode = studentCode;
        this.parent = parent;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public StudentDTO(String fullName, String major, Integer age, Double gpa, String studentCode) {
        this.fullName = fullName;
        this.major = major;
        this.age = age;
        this.gpa = gpa;
        this.studentCode = studentCode;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public StudentDTO(String fullName, String major, Integer age, Double gpa) {
        this.fullName = fullName;
        this.major = major;
        this.age = age;
        this.gpa = gpa;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public StudentDTO(String fullName, String major) {
        this.fullName = fullName;
        this.major = major;
    }

    public StudentDTO() {
    }
}
