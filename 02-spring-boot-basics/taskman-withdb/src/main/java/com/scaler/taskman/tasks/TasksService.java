package com.scaler.taskman.tasks;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TasksService {
    /**
     * Returns all tasks.
     * @return
     */
    List<TaskEntity> getAllTasks();

    /**
     * Returns task by id.
     * @param id - task id
     * @return - task
     */
    TaskEntity getTaskById(Long id);

    /**
     * Create a new task
     * @param task - task
     */
    void addTask(TaskEntity task);

    /**
     * Update task
     * @param task - task
     */
    void updateTask(Long id, TaskEntity task);

    /**
     * Delete task
     * @param id - task id to be deleted
     */
    void deleteTask(Long id);
}
