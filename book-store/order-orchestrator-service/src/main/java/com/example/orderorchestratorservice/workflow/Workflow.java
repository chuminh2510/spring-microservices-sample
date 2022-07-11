package com.example.orderorchestratorservice.workflow;


import com.example.dto.BaseDto;

import java.util.List;

public interface Workflow {
    List<WorkflowStep<BaseDto, Integer>> getSteps();
}
