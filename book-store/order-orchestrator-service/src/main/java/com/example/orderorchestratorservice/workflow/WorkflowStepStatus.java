package com.example.orderorchestratorservice.workflow;

import lombok.Getter;

@Getter
public enum WorkflowStepStatus {
    START,
    IN_PROGRESS,
    PENDING,
    CANCEL,
    END;
}
