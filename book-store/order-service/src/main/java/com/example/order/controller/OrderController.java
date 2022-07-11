package com.example.order.controller;

import com.example.dto.BookRequestDto;
import com.example.dto.OrderDto;
import com.example.dto.OrderRequestDto;
import com.example.dto.UserRequestDto;
import com.example.order.entity.Order;
import com.example.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;


    @GetMapping(value = "")
    public List<OrderDto> findAll() {
        log.info("findAll");
        return this.orderService.findAll().stream().map(Order::toOrderDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/dummy")
    public OrderRequestDto findAll2() {
        OrderRequestDto dto = new OrderRequestDto();
        UserRequestDto userDto = new UserRequestDto();
        userDto.setId(5);
        dto.setUserRequestDto(userDto);
        BookRequestDto bookDto = new BookRequestDto();
        bookDto.setId(6);
        bookDto.setQuantity(6);
        bookDto.setPrice(6);
        dto.setBookRequestDto(bookDto);
        dto.setDescription("OMG");
//        orderService.save(dto);
        return dto;
    }

    @PostMapping(value = "")
    public OrderDto insert(@RequestBody OrderRequestDto data) {
        log.info("insert");
        return orderService.save(data).toOrderDto();
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
