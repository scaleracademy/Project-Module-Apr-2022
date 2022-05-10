package com.scaler.taskman.tasks;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TasksService tasksService;


    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getAllTasks(){
        List<TaskEntity> taskEntityList  = tasksService.getAllTasks();

        return ResponseEntity.ok(taskEntityList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskByID(@PathVariable("id") Long id){

        TaskEntity taskEntity = tasksService.getTaskById(id);
        return ResponseEntity.ok(taskEntity);
    }

    @PostMapping()
    public String addTask(@RequestBody TaskRequest taskRequest){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setName(taskRequest.getName());
        taskEntity.setDueDate(taskRequest.getDueDate());
        taskEntity.setCompleted(taskRequest.getCompleted());
        tasksService.addTask(taskEntity);

        return "Task created successfully";
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateTask(@PathVariable("id") Long id, @RequestBody TaskRequest taskRequest){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(id);
        taskEntity.setName(taskRequest.getName());
        taskEntity.setDueDate(taskRequest.getDueDate());
        taskEntity.setCompleted(taskRequest.getCompleted());

        tasksService.updateTask(id,taskEntity);

        return ResponseEntity.ok("Task ID " + id + "updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable("id") Long id){
        tasksService.deleteTask(id);
        return ResponseEntity.accepted().body("Task Id " + id + "deleted!!");
    }
}
