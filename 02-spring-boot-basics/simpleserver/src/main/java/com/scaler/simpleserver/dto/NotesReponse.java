package com.scaler.simpleserver.dto;

import com.scaler.simpleserver.models.Notes;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class NotesReponse {
    private int notesCount;
    private List<Notes> notes;
}
