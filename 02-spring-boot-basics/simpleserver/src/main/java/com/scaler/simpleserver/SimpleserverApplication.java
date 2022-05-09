package com.scaler.simpleserver;

import com.scaler.simpleserver.services.tasks.Taskh2Impl;
import com.scaler.simpleserver.services.tasks.TasksService;
import com.scaler.simpleserver.services.tasks.TasksServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
public class SimpleserverApplication {
    private static boolean isTestingEnv = true;

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
            return new Taskh2Impl();
        } else {
            System.out.println("========= Production environment real services");
            // TODO: return a different implementation for prod
            return new TasksServiceImpl();
        }
    }

    @Bean
    public Docket taskAPI(){
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis((RequestHandlerSelectors.basePackage("com.scaler.simpleserver"))).build();
    }

}
