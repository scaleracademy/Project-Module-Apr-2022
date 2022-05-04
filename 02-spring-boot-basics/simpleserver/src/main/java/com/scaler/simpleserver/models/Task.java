package com.scaler.simpleserver.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Task {
    private int id;
    private String name;
    private boolean completed;
    private Date dueBy;
}
