package com.example.orderorchestratorservice.step;

import com.example.dto.BookDto;
import com.example.dto.BookRequestDto;
import com.example.orderorchestratorservice.workflow.WorkflowStep;
import com.example.orderorchestratorservice.workflow.WorkflowStepStatus;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class BookStep implements WorkflowStep<BookDto, Integer> {
    private final WebClient webClient;
    private final BookRequestDto bookRequestDto;
    private WorkflowStepStatus stepStatus = WorkflowStepStatus.START;

    public BookStep(WebClient webClient, BookRequestDto bookRequestDto) {
        this.webClient = webClient;
        this.bookRequestDto = bookRequestDto;
    }

    @Override
    public WorkflowStepStatus getStatus() {
        return this.stepStatus;
    }

    @Override
    public Mono<BookDto> process() {
        return this.webClient.post()
                .uri("/books")
                .body(BodyInserters.fromValue(this.bookRequestDto))
                .retrieve()
                .bodyToMono(BookDto.class)
//                .map(r -> r != null)
                .doOnNext(bookDto -> {
                    if (bookDto != null) {
                        this.stepStatus = WorkflowStepStatus.END;
                        this.bookRequestDto.setId(bookDto.getId());
                    } else {
                        this.stepStatus = WorkflowStepStatus.CANCEL;
                    }
                });
    }

    @Override
    public Mono<Integer> revert() {
        return this.webClient.post()
                .uri("/books")
                .body(BodyInserters.fromValue(this.bookRequestDto))
                .retrieve()
                .bodyToMono(Integer.class)
                .map(r -> r)
                .onErrorReturn(0);
    }
}
