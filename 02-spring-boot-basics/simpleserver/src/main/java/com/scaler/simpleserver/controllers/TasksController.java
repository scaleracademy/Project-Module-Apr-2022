package com.scaler.simpleserver.controllers;

import com.scaler.simpleserver.dto.ErrorResponse;
import com.scaler.simpleserver.dto.SuccessResponse;
import com.scaler.simpleserver.dto.TasksResponse;
import com.scaler.simpleserver.models.Task;
import com.scaler.simpleserver.services.tasks.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    @Autowired
    private TasksService tasksService;

    @GetMapping("")
    public ResponseEntity<TasksResponse> getAllTasks() {
        var tasks = tasksService.getAllTasks();
        return ResponseEntity.ok(new TasksResponse(tasks.size(), tasks));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Integer id) {
        var task = tasksService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> deleteTaskById(@PathVariable("id") Integer id) {
        tasksService.deleteTask(id);
        return ResponseEntity.accepted().body(new SuccessResponse("Task no = " + id + " deleted"));
    }

    @PostMapping("")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task newTask = tasksService.createTask(task);
        return new ResponseEntity<Task>(newTask, null, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") String id, @RequestBody Task task) {
        int newId = Integer.parseInt(id);
        Task updatedTask = tasksService.updateTask(newId, task);
        return new ResponseEntity<Task>(updatedTask, null, HttpStatus.OK);
    }

    @ExceptionHandler(TasksService.TaskNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
