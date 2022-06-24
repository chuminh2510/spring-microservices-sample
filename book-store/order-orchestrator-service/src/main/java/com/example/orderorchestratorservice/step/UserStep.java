package com.example.orderorchestratorservice.step;

import com.example.bookstore.dto.UserDto;
import com.example.bookstore.dto.UserRequestDto;
import com.example.orderorchestratorservice.workflow.WorkflowStep;
import com.example.orderorchestratorservice.workflow.WorkflowStepStatus;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class UserStep implements WorkflowStep {
    private final WebClient webClient;
    private final UserRequestDto userDto;
    private WorkflowStepStatus stepStatus = WorkflowStepStatus.START;

    public UserStep(WebClient webClient, UserRequestDto userDto) {
        this.webClient = webClient;
        this.userDto = userDto;
    }

    @Override
    public WorkflowStepStatus getStatus() {
        return this.stepStatus;
    }

    @Override
    public Mono<Boolean> process() {
        return this.webClient.post()
                .uri("/users")
                .body(BodyInserters.fromValue(this.userDto))
                .retrieve()
                .bodyToMono(UserDto.class)
                .map(r -> r != null)
                .doOnNext(b -> this.stepStatus = b ? WorkflowStepStatus.END : WorkflowStepStatus.CANCEL);
    }

    @Override
    public Mono<Boolean> revert() {
        return this.webClient.post()
                .uri("/users")
                .body(BodyInserters.fromValue(this.userDto))
                .retrieve()
                .bodyToMono(Void.class)
                .map(r -> true)
                .onErrorReturn(false);
    }
}
