package com.scaler.taskman.notes;

import com.scaler.taskman.tasks.TaskEntity;
import com.scaler.taskman.tasks.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{id}/notes")
public class NotesController {
    private final NotesService notesService;
    private final TasksService tasksService;

    @Autowired
    public NotesController(NotesService notesService, TasksService tasksService) {

        this.notesService = notesService;
        this.tasksService = tasksService;
    }


    @GetMapping("")
    public ResponseEntity<List<NoteEntity>> getNotesDetails(@PathVariable("id") Long id){

        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(id);

        List<NoteEntity> response = notesService.getNotesForTask(taskEntity);
        return ResponseEntity.ok(response);
    }

    @PostMapping("")
    public ResponseEntity<NotesSuccessResponse> addNotesToTask(@PathVariable("id") Long id ,
                                                               @RequestBody NotesRequest notesRequest){

        TaskEntity taskEntity = tasksService.getTaskById(id);
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setText(notesRequest.getText());
        notesService.addNoteToTask(taskEntity,noteEntity);
        return ResponseEntity.ok().body(
                new NotesSuccessResponse(("Notes added to Task ID " + id + "successfully")));
    }

    @DeleteMapping("")
    public ResponseEntity<NotesSuccessResponse> deleteNotesById(@PathVariable("id") Long id){

        notesService.deleteNote(id);
        return ResponseEntity.accepted().body(new NotesSuccessResponse("Note ID " + id + "deleted!!"));
    }
}
