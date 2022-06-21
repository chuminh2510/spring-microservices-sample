package com.example.gatewayservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {
    @GetMapping("/books")
    public String bookFallback() {
        return "Books: Fallback";
    }

    @GetMapping("/user")
    public String userFallback() {
        return "Users: Fallback";
    }
}
