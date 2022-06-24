package com.example.orderorchestratorservice.step;

import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.dto.UserDto;
import com.example.orderorchestratorservice.workflow.WorkflowStep;
import com.example.orderorchestratorservice.workflow.WorkflowStepStatus;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class BookStep implements WorkflowStep {
    private final WebClient webClient;
    private final BookRequestDto bookDto;
    private WorkflowStepStatus stepStatus = WorkflowStepStatus.START;

    public BookStep(WebClient webClient, BookRequestDto bookDto) {
        this.webClient = webClient;
        this.bookDto = bookDto;
    }

    @Override
    public WorkflowStepStatus getStatus() {
        return this.stepStatus;
    }

    @Override
    public Mono<Boolean> process() {
        return this.webClient.post()
                .uri("/books")
                .body(BodyInserters.fromValue(this.bookDto))
                .retrieve()
                .bodyToMono(UserDto.class)
                .map(r -> r != null)
                .doOnNext(b -> this.stepStatus = b ? WorkflowStepStatus.END : WorkflowStepStatus.CANCEL);
    }

    @Override
    public Mono<Boolean> revert() {
        return this.webClient.post()
                .uri("/books")
                .body(BodyInserters.fromValue(this.bookDto))
                .retrieve()
                .bodyToMono(Void.class)
                .map(r -> true)
                .onErrorReturn(false);
    }
}
