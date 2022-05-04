package com.scaler.simpleserver.services;

import com.scaler.simpleserver.models.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TasksServiceImpl implements TasksService {
    private ArrayList<Task> taskList;

    public TasksServiceImpl() {
        taskList = new ArrayList<>();
        taskList.add(new Task(1, "sample task", false, new Date()));
        taskList.add(new Task(2, "another task", false, new Date()));
        taskList.add(new Task(3, "more tasks", false, new Date()));
    }

    @Override
    public List<Task> getAllTasks() {
        return taskList;
    }

    @Override
    public Task getTaskById(int id) {
        // TODO: implement
        return null;
    }

    @Override
    public Task createTask(Task task) {
        // TODO: implement
        return null;
    }

    @Override
    public Task updateTask(int id, Task task) {
        // TODO: implement
        return null;
    }

    @Override
    public void deleteTask(int id) {
        // TODO: implement

    }
}
