package com.scaler.simpleserver;

import com.scaler.simpleserver.services.TasksService;
import com.scaler.simpleserver.services.TasksServiceImpl;
import com.scaler.simpleserver.services.TasksServiceTestImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SimpleserverApplication {
    private static boolean isTestingEnv = false;

    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0].equals("test")) {
                isTestingEnv = true;
            }
        }
        SpringApplication.run(SimpleserverApplication.class, args);
    }

    @Bean
    public TasksService tasksService() {
        if (isTestingEnv) {
            System.out.println("========  Testing environment mock services");
            return new TasksServiceTestImpl();
        } else {
            System.out.println("========= Production environment real services");
            // TODO: return a different implementation for prod
            return new TasksServiceImpl();
        }
    }

}
