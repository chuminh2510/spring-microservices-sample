package com.example.orderorchestratorservice.service;


import com.example.dto.OrderRequestDto;
import com.example.dto.OrderResponseDto;
import com.example.orderorchestratorservice.workflow.Workflow;
import reactor.core.publisher.Mono;

public interface OrchestratorService {

    Mono<OrderResponseDto> createOrder(OrderRequestDto requestDto);

    Mono<OrderResponseDto> revertOrder(Workflow workflow, OrderRequestDto requestDto, Throwable ex);

}
