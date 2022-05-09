package com.scaler.taskman.notes;

import com.scaler.taskman.tasks.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<NoteEntity, Long> {

    List<NoteEntity> findAllByTaskId(Long taskId);
}
