package com.example.bookstore.dto;

import com.example.bookstore.status.OrderStatus;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Integer quantity;
    private String description;
    private OrderStatus status;
}
