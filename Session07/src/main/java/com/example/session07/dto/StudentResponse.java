package com.example.session07.dto;

public class StudentResponse {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public StudentResponse() {
    }
}
