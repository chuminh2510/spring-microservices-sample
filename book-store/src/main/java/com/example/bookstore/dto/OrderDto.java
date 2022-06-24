package com.example.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Integer quantity;
    private String description;
}
