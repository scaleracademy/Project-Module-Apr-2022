package com.scaler.simpleserver.services.tasks;

import com.scaler.simpleserver.models.Task;
import com.scaler.simpleserver.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Taskh2Impl implements TasksService {
    @Autowired
    TaskRepository taskRepo;

    @Override
    public List<Task> getAllTasks() {
        List<Task> list = new ArrayList<>();
        taskRepo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Task getTaskById(int id) {
        return taskRepo.findById(id).get();
    }

    @Override
    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    @Override
    public Task updateTask(int id, Task task) {
        Task updatedTask = taskRepo.findById(id).get();
        updatedTask.setName(task.getName());
        updatedTask.setCompleted(task.isCompleted());
        return taskRepo.save(updatedTask);
    }

    @Override
    public void deleteTask(int id) {
        taskRepo.deleteById(id);
    }
}
