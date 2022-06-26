package com.example.order.service;

import com.example.bookstore.dto.OrderRequestDto;
import com.example.bookstore.dto.OrderResponseDto;
import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.FluxSink;

import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepo;

    private FluxSink<OrderRequestDto> sink;

    @Override
    public Order save(OrderRequestDto data) {
        Order order = Order.from(data);
        Order out = orderRepo.save(order);
        this.sink.next(data);
        log.info("Finish save order");
        return out;
    }

    @Override
    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    @Override
    public Order update(OrderRequestDto data) {
        return null;
    }

    @Override
    public int delete(Order data) {
        return 0;
    }

    @Override
    public Order findById(Integer id) {
        return null;
    }

    @Override
    public void updateCompletedTime(OrderResponseDto reponseDto) {
        log.info("Completed Order");
    }

    @Autowired
    public void setOrderRepo(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Autowired
    public void setSink(FluxSink<OrderRequestDto> sink) {
        this.sink = sink;
    }
}
