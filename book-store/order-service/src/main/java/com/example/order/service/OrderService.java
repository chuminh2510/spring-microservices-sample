package com.example.order.service;

import com.example.dto.OrderRequestDto;
import com.example.dto.OrderResponseDto;
import com.example.order.entity.Order;
import com.example.service.BaseService;

public interface OrderService extends BaseService<Order, Integer, OrderRequestDto> {
    public void updateCompletedTime(OrderResponseDto reponseDto);
}
