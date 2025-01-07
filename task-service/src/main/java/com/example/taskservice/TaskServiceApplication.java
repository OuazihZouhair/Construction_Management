package com.example.taskservice;

import com.example.taskservice.entities.Task;
import com.example.taskservice.entities.TaskResource;
import com.example.taskservice.enums.Status;
import com.example.taskservice.feign.ProjectRestClient;
import com.example.taskservice.feign.ResourceRestClient;
import com.example.taskservice.model.Project;
import com.example.taskservice.model.Resource;
import com.example.taskservice.repository.TaskRepository;
import com.example.taskservice.repository.TaskResourceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class TaskServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(TaskRepository taskRepository,
                                        TaskResourceRepository taskResourceRepository,
                                        ProjectRestClient projectRestClient,
                                        ResourceRestClient resourceRestClient){

        return args -> {
            Collection<Project> projects = projectRestClient.getAllProjects().getContent();
            Collection<Resource> resources = resourceRestClient.getAllResources().getContent();

            projects.forEach(project -> {
                String dateString1 = "2024-03-22";
                String dateString2 = "2024-12-22";
                LocalDate start = LocalDate.parse(dateString1);
                LocalDate end = LocalDate.parse(dateString2);
                Task task = new Task("Description1", start, end, Status.TO_DO, project.getId());
                taskRepository.save(task);

                resources.forEach(resource -> {
                    TaskResource taskResource = new TaskResource(resource.getId(), 1 + new Random().nextInt(10), task);
                    taskResourceRepository.save(taskResource);
                });
            });
        };
    }

}
