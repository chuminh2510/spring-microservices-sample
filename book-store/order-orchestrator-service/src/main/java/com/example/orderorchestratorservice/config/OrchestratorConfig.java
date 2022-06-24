package com.example.orderorchestratorservice.config;

import com.example.bookstore.dto.OrderRequestDto;
import com.example.bookstore.dto.OrderResponseDto;
import com.example.orderorchestratorservice.service.OrchestratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Slf4j
@Configuration
public class OrchestratorConfig {
    private OrchestratorService orchestratorService;

    @Bean
    public Function<Flux<OrderRequestDto>, Flux<OrderResponseDto>> processor() {
        return flux -> flux
                .flatMap(dto -> this.orchestratorService.createOrder(dto))
                .doOnNext(dto -> log.info("Status: " + dto.toString()));
    }

    @Autowired
    public void setOrchestratorService(OrchestratorService orchestratorService) {
        this.orchestratorService = orchestratorService;
    }
}
