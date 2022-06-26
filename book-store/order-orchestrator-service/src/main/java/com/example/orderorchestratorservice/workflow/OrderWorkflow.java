package com.example.orderorchestratorservice.workflow;

import com.example.bookstore.dto.BaseDto;

import java.util.List;

public class OrderWorkflow implements Workflow {
    private final List<WorkflowStep<BaseDto, Integer>> steps;

    public OrderWorkflow(List<WorkflowStep<BaseDto, Integer>> steps) {
        this.steps = steps;
    }

    @Override
    public List<WorkflowStep<BaseDto, Integer>> getSteps() {
        return this.steps;
    }
}
