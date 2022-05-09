package com.scaler.taskman.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
public class TasksRepositoryTests {

    @Autowired TasksRepository tasksRepo;

    @Test
    void can_create_new_task() {
        tasksRepo.save(new TaskEntity("this is a sample task"));
    }

    @Test
    void can_save_and_retrieve_task() {
        tasksRepo.save(new TaskEntity("this is another task"));

        TaskEntity task = tasksRepo.findById(2L).get();
        assert task.getName().equals("this is another task");
    }



}
