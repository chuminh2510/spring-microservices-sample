package com.example.order.config;

import com.example.dto.OrderRequestDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.FluxSink;

@Configuration
public class AppConfig {
    @Bean
    public DirectProcessor<OrderRequestDto> publisher() {

        return DirectProcessor.create();
    }

    @Bean
    public FluxSink<OrderRequestDto> sink(DirectProcessor<OrderRequestDto> publisher) {
        return publisher.sink();
    }
}
