package com.example.order.service;

import com.example.bookstore.dto.OrderRequestDto;
import com.example.bookstore.dto.OrderResponseDto;
import com.example.bookstore.service.BaseService;
import com.example.order.entity.Order;

public interface OrderService extends BaseService<Order, Integer, OrderRequestDto> {
    public void updateCompletedTime(OrderResponseDto reponseDto);
}
