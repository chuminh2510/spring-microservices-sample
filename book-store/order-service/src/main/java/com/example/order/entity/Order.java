package com.example.order.entity;

import com.example.dto.OrderDto;
import com.example.dto.OrderRequestDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Integer quantity;
    private Integer price;
    private String description;

    public OrderDto toOrderDto() {
        OrderDto dto = new OrderDto();
        dto.setId(this.id);
        dto.setUserId(this.userId);
        dto.setBookId(this.bookId);
        dto.setQuantity(this.quantity);
        dto.setDescription(this.description);
        return dto;
    }

    public static Order from(OrderRequestDto dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setUserId(dto.getUserRequestDto().getId());
        order.setBookId(dto.getBookRequestDto().getId());
        order.setQuantity(dto.getBookRequestDto().getQuantity());
        order.setPrice(dto.getBookRequestDto().getPrice());
        order.setDescription(dto.getDescription());
        return order;
    }
}
