package com.example.authservice.security;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;

@Component
public class JwtTokenUtil implements Serializable {
    private static final String secretKey = "";
    private static final long JWT_TOKEN_EXPIRED = 24 * 60 * 60;

//    public String generateToken(Map<String, Object> claims, String subject) {
//
//    }

}
