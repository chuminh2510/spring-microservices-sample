package com.example.bookstore.dto;

import lombok.Data;

@Data
public class BookRequestDto {
    private Integer id;
    private String name;
    private Integer quantity;
    private String category;
    private Integer price;
}
