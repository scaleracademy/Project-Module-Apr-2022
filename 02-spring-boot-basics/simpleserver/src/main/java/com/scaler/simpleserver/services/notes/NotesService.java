package com.scaler.simpleserver.services.notes;

import com.scaler.simpleserver.models.Notes;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NotesService {
    List<Notes> getAllNotes();
    Notes getNotesById(int id);
    Notes createNotes(Notes notes);
    Notes updateNotes(int id, Notes notes);
    void deleteNotes(int id);

    public class NotesNotFoundException extends Throwable {
        public NotesNotFoundException(int id) {
            super("Could not find notes " + id);
        }

    }
}
