package com.example.bookstore.dto;

import com.example.bookstore.status.OrderStatus;
import lombok.Data;

@Data
public class OrderRequestDto {
    private Integer id;

    private BookRequestDto bookRequestDto;
    private UserRequestDto userRequestDto;

    private String description;


    public BookRequestDto toBookRequestDto() {
        return bookRequestDto;
    }

    public UserRequestDto toUserRequestDto() {
        return userRequestDto;
    }

    public OrderResponseDto toOrderResponseDto(OrderStatus status) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(this.id);
        dto.setUserId(this.getUserRequestDto().getId());
        dto.setBookId(this.getBookRequestDto().getId());
        dto.setQuantity(this.getBookRequestDto().getQuantity());
        dto.setDescription(this.getDescription());
        dto.setStatus(status);
        return dto;
    }
}
