package com.example.blogcms.dto;

import jakarta.validation.constraints.NotBlank;

public class AuthorRequest {

    @NotBlank(message = "Author name is required")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
