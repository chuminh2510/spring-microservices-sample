package com.example.status;

import lombok.Getter;

@Getter
public enum OrderStatus {
    ORDER_CREATED,
    ORDER_CANCELLED,
    ORDER_COMPLETED;
}
