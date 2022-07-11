package com.example.orderorchestratorservice.service;

import com.example.dto.OrderRequestDto;
import com.example.dto.OrderResponseDto;
import com.example.orderorchestratorservice.step.BookStep;
import com.example.orderorchestratorservice.step.UserStep;
import com.example.orderorchestratorservice.workflow.*;
import com.example.status.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class OrchestratorServiceImpl implements OrchestratorService {
    private WebClient userClient;
    private WebClient bookClient;

    @Override
    public Mono<OrderResponseDto> createOrder(OrderRequestDto requestDto) {
        log.info("createOrder");
        Workflow orderWorkFlow = this.getOrderWorkflow(requestDto);

        return Flux.fromStream(() -> orderWorkFlow.getSteps().stream())
                .flatMap(WorkflowStep::process)
                .handle((((dto, objectSynchronousSink) -> {
                    log.info("Object Dto: " + dto);
                    if (dto != null) {
                        log.info("Waiting next step");
                        objectSynchronousSink.next(true);
                    } else {
                        log.error("Create order failed");
                        objectSynchronousSink.error(new WorkflowException("Create order failed"));
                    }

                })))
                .then(Mono.fromCallable(() -> requestDto.toOrderResponseDto(OrderStatus.ORDER_COMPLETED)))
                .onErrorResume(ex -> this.revertOrder(orderWorkFlow, requestDto, ex));
    }

    @Override
    public Mono<OrderResponseDto> revertOrder(Workflow workflow, OrderRequestDto requestDto, Throwable ex) {
        log.info("revertOrder");
        log.error("Error is ", ex);
        return Flux.fromStream(() -> workflow.getSteps().stream())
                .filter(wf -> wf.getStatus().equals(WorkflowStepStatus.END))
                .flatMap(WorkflowStep::revert)
                .retry(3)
                .then(Mono.just(requestDto.toOrderResponseDto(OrderStatus.ORDER_CANCELLED)));
    }

    private Workflow getOrderWorkflow(OrderRequestDto requestDto) {
        WorkflowStep userStep = new UserStep(this.userClient, requestDto.toUserRequestDto());
        WorkflowStep bookStep = new BookStep(this.bookClient, requestDto.toBookRequestDto());

        return new OrderWorkflow(List.of(userStep, bookStep));
    }

    @Autowired
    @Qualifier("user")
    public void setUserClient(WebClient userClient) {
        this.userClient = userClient;
    }

    @Autowired
    @Qualifier("book")
    public void setBookClient(WebClient bookClient) {
        this.bookClient = bookClient;
    }
}
