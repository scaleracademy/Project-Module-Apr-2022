package com.scaler.taskman.tasks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {

    private String name;
    private Date dueDate;
    private Boolean completed;
}
