package com.scaler.taskman;

import com.scaler.taskman.notes.NotesRepository;
import com.scaler.taskman.notes.NotesService;
import com.scaler.taskman.notes.NotesServiceImpl;
import com.scaler.taskman.tasks.TasksRepository;
import com.scaler.taskman.tasks.TasksService;
import com.scaler.taskman.tasks.TasksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    private final TasksRepository tasksRepository;
    private final NotesRepository notesRepository;

    @Autowired
    public ServiceConfig(TasksRepository tasksRepository, NotesRepository notesRepository) {
        this.tasksRepository = tasksRepository;
        this.notesRepository = notesRepository;
    }

    @Bean
    public TasksService taskService() {
        return new TasksServiceImpl(tasksRepository);
    }

    @Bean
    NotesService notesService() {
        return new NotesServiceImpl(notesRepository);
    }
}
