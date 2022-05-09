package com.scaler.simpleserver.services.notes;

import com.scaler.simpleserver.models.Notes;
import com.scaler.simpleserver.repo.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NotesServiceImpl implements NotesService{

    @Autowired
    NotesRepository notesRepository;

    @Override
    public List<Notes> getAllNotes() {
        List<Notes> list = new ArrayList<>();
        notesRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Notes getNotesById(int id) {
        return notesRepository.findById(id).get();
    }

    @Override
    public Notes createNotes(Notes notes) {
        return notesRepository.save(notes);
    }

    @Override
    public Notes updateNotes(int id, Notes notes) {
        Notes updatedNotes = notesRepository.findById(id).get();
        updatedNotes.setText(notes.getText());
        updatedNotes.setTaskid(notes.getTaskid());
        return notesRepository.save(updatedNotes);
    }

    @Override
    public void deleteNotes(int id) {
        notesRepository.deleteById(id);
    }
}
