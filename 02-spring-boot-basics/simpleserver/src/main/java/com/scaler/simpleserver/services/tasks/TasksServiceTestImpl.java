package com.scaler.simpleserver.services.tasks;

import com.scaler.simpleserver.models.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class TasksServiceTestImpl implements TasksService {
    private ArrayList<Task> taskList;

    public TasksServiceTestImpl() {
        taskList = new ArrayList<>();
        taskList.add(new Task(1, "test task 1", false, new Date()));
        taskList.add(new Task(3, "test task 3", false, new Date()));
    }
    private Task findTaskById(int id) {
        AtomicReference<Task> task = null;
        taskList.forEach(t -> {
            if (t.getId() == id) { task.set(t); }
        });
        if (task.get() == null) {
            throw new TaskNotFoundException(id);
        }
        return task.get();
    }

    @Override
    public List<Task> getAllTasks() {
        return taskList;
    }

    @Override
    public Task getTaskById(int id) {
        return findTaskById(id);
    }

    @Override
    public Task createTask(Task task) {
        // TODO: generate new unique id
        Task newTask = new Task(task.getId(), task.getName(), task.isCompleted(), task.getDueBy());
        taskList.add(newTask);
        return task;
    }

    @Override
    public Task updateTask(int id, Task task) {
        Task existingTask = findTaskById(id);

        if (task.getName() != null) { existingTask.setName(task.getName()); }
        if (task.isCompleted()) { existingTask.setCompleted(task.isCompleted()); }
        if (task.getDueBy() != null) { existingTask.setDueBy(task.getDueBy()); }

        return existingTask;
    }

    @Override
    public void deleteTask(int id) {
        taskList.remove(findTaskById(id));
    }


}
