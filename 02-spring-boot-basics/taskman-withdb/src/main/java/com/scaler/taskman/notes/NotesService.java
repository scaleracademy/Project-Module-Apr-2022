package com.scaler.taskman.notes;

import com.scaler.taskman.tasks.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotesService {

    /**
     * Returns all notes for a given task.
     * @param task the task to get the notes for
     * @return the notes for the task
     */
    List<NoteEntity> getNotesForTask(TaskEntity task);

    /**
     * Creates a new note for a given task.
     * @param task the task to create the note for
     * @param note the note to create
     */
    void addNoteToTask(TaskEntity task, NoteEntity note);

    /**
     * Deletes an existing note for a given task.
     * @param id the id of the note to delete
     */
    void deleteNote(Long id);

}
