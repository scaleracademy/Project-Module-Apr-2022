package com.scaler.simpleserver.controllers;

import com.scaler.simpleserver.dto.ErrorResponse;
import com.scaler.simpleserver.dto.NotesReponse;
import com.scaler.simpleserver.dto.SuccessResponse;
import com.scaler.simpleserver.models.Notes;
import com.scaler.simpleserver.services.notes.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;

    @GetMapping
    public ResponseEntity<NotesReponse> getAllNotes() {
        var notes= notesService.getAllNotes();
        return ResponseEntity.ok(new NotesReponse(notes.size(), notes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notes> getTaskById(@PathVariable("id") Integer id) {
        var task = notesService.getNotesById(id);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deleteTaskById(@PathVariable("id") Integer id) {
        notesService.deleteNotes(id);
        return ResponseEntity.accepted().body(new SuccessResponse("Task no = " + id + " deleted"));
    }

    @PostMapping("")
    public ResponseEntity<Notes> createTask(@RequestBody Notes notes) {
        Notes newNotes = notesService.createNotes(notes);
        return new ResponseEntity<Notes>(newNotes, null, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Notes> updateTask(@PathVariable("id") String id, @RequestBody Notes notes) {
        int newId = Integer.parseInt(id);
        Notes updatedNotes = notesService.updateNotes(newId, notes);
        return new ResponseEntity<Notes>(updatedNotes, null, HttpStatus.OK);
    }

    @ExceptionHandler(NotesService.NotesNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

}
