package com.example.order.config;

import com.example.dto.OrderRequestDto;
import com.example.dto.OrderResponseDto;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Configuration
public class OrderEventHandlerConfig {
    private DirectProcessor<OrderRequestDto> source;

    private OrderService orderService;

    @Bean
    public Supplier<Flux<OrderRequestDto>> supplier() {
        return () -> Flux.from(source);
    }

    @Bean
    public Consumer<Flux<OrderResponseDto>> consumer() {
        return flux -> flux.subscribe(responseDto -> this.orderService.updateCompletedTime(responseDto));
    }

    @Autowired
    public void setSource(DirectProcessor<OrderRequestDto> source) {
        this.source = source;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
