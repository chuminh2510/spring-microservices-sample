package com.example.orderorchestratorservice.workflow;

import reactor.core.publisher.Mono;

public interface WorkflowStep<T, V> {
    WorkflowStepStatus getStatus();

    Mono<T> process();

    Mono<V> revert();
}
