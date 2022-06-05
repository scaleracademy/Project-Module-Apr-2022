package com.scaler.taskman.notes;

import com.scaler.taskman.tasks.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NotesServiceImpl implements NotesService {
    private final NotesRepository notesRepo;

    @Autowired
    public NotesServiceImpl(NotesRepository notesRepo) {

        this.notesRepo = notesRepo;
    }

    @Override`
    public List<NoteEntity> getNotesForTask(TaskEntity task) {

        return notesRepo.findAllByTaskId(task.getId());
    }

    @Override
    public void addNoteToTask(TaskEntity task, NoteEntity note) {
        note.setTask(task);
        notesRepo.save(note);
    }

    @Override
    public void deleteNote(Long id) {
        notesRepo.deleteById(id);
    }
}
