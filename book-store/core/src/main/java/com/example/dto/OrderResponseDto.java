package com.example.dto;

import com.example.status.OrderStatus;
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
