package com.example.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator gatewayLocators(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("bookModule", r -> r.path("/books/**").filters(f -> f.circuitBreaker(config -> config.setFallbackUri("forward:/fallback/books"))).uri("lb://book-service"))
                .route("userModule", r -> r.path("/users/**").filters(f -> f.circuitBreaker(config -> config.setFallbackUri("forward:/fallback/users"))).uri("lb://user-service"))
                .route("orderModule", r -> r.path("/orders/**").filters(f -> f.circuitBreaker(config -> config.setFallbackUri("forward:/fallback/orders"))).uri("lb://order-service"))
                .build();
    }
}
