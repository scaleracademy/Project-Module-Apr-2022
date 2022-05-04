package com.scaler.simpleserver.dto;

import com.scaler.simpleserver.models.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TasksResponse {
    private int taskCount;
    private List<Task> tasks;
}
