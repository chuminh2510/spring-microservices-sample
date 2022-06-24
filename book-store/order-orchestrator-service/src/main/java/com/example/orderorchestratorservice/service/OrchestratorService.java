package com.example.orderorchestratorservice.service;


import com.example.bookstore.dto.OrderRequestDto;
import com.example.bookstore.dto.OrderResponseDto;
import com.example.orderorchestratorservice.workflow.Workflow;
import reactor.core.publisher.Mono;

public interface OrchestratorService {

    Mono<OrderResponseDto> createOrder(OrderRequestDto requestDto);

    Mono<OrderResponseDto> revertOrder(Workflow workflow, OrderRequestDto requestDto);

}
