package com.scaler.simpleserver.services.tasks;

import com.scaler.simpleserver.models.Task;
import com.scaler.simpleserver.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TasksService {

    List<Task> getAllTasks();
    Task getTaskById(int id);
    Task createTask(Task task);
    Task updateTask(int id, Task task);
    void deleteTask(int id);

    class TaskNotFoundException extends IllegalArgumentException {
        public TaskNotFoundException(int id) {
            super("Could not find task " + id);
        }
    }
}
