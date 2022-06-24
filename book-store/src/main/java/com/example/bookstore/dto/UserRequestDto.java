package com.example.bookstore.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private Integer id;

    private String name;

    private Integer age;

    private String email;
}
