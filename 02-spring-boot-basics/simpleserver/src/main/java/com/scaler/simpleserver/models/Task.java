package com.scaler.simpleserver.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="task")
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="taskid")
    private int id;
    @Column(name="name", updatable = true, nullable = false)
    private String name;
    @Column(name = "completed", updatable = true, nullable = false)
    private boolean completed;
    @Column(name = "dueby", updatable = true, nullable = true)
    private Date dueBy;
}
