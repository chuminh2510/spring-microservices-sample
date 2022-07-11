package com.example.orderorchestratorservice.step;

import com.example.dto.UserDto;
import com.example.dto.UserRequestDto;
import com.example.orderorchestratorservice.workflow.WorkflowStep;
import com.example.orderorchestratorservice.workflow.WorkflowStepStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
public class UserStep implements WorkflowStep<UserDto, Integer> {
    private final WebClient webClient;
    private final UserRequestDto userRequestDto;
    private WorkflowStepStatus stepStatus = WorkflowStepStatus.START;

    public UserStep(WebClient webClient, UserRequestDto userRequestDto) {
        this.webClient = webClient;
        this.userRequestDto = userRequestDto;
    }

    @Override
    public WorkflowStepStatus getStatus() {
        return this.stepStatus;
    }

    @Override
    public Mono<UserDto> process() {
        log.info("process");
        return this.webClient.post()
                .uri("/users")
                .body(BodyInserters.fromValue(this.userRequestDto))
                .retrieve()
                .bodyToMono(UserDto.class)
//                .map(userDto -> userDto)
                .doOnNext((userDto) -> {
                    if (userDto != null) {
                        this.stepStatus = WorkflowStepStatus.END;
                        this.userRequestDto.setId(userDto.getId());
                    } else {
                        this.stepStatus = WorkflowStepStatus.CANCEL;
                    }
                });
    }

    @Override
    public Mono<Integer> revert() {
        log.info("revert");
        return this.webClient.delete()
                .uri("/users/" + this.userRequestDto.getId())
                .retrieve()
                .bodyToMono(Integer.class)
                .map(r -> r)
                .onErrorReturn(0);
    }
}
