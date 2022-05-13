package com.scaler.taskman.tasks;

import com.scaler.taskman.notes.NoteEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @Column
    private String name;

    @Column
    private Date dueDate;

    @Column
    private Boolean completed;

    @OneToMany
    private List<NoteEntity> notes;
}
