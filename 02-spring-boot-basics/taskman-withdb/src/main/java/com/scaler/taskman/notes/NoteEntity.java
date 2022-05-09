package com.scaler.taskman.notes;

import com.scaler.taskman.tasks.TaskEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity(name = "notes")
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity task;

}
