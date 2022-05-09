package com.scaler.taskman.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import java.util.List;

public class TasksServiceImpl implements TasksService {
    private final TasksRepository tasksRepo;

    @Autowired
    public TasksServiceImpl(TasksRepository tasksRepo) {
        this.tasksRepo = tasksRepo;
    }

    @Override
    public List<TaskEntity> getAllTasks() {
        return tasksRepo.findAll();
    }

    @Override
    public TaskEntity getTaskById(Long id) {
        return tasksRepo.getById(id);
    }

    @Override
    public void addTask(TaskEntity task) {
        tasksRepo.save(task);
    }

    @Override
    public void updateTask(Long id, TaskEntity task) {
        task.setId(id);
        tasksRepo.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        tasksRepo.deleteById(id);
    }
}
