package com.example.session07.dto;

import com.example.session07.validation.ViettelPhone;
import jakarta.validation.constraints.NotBlank;

public class ParentDTO {
    @NotBlank(message = "Tên phụ huynh không được để trống")
    private String name;

    @NotBlank(message = "Số điện thoại không được để trống" )
    @ViettelPhone
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ParentDTO(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public ParentDTO() {
    }
}
