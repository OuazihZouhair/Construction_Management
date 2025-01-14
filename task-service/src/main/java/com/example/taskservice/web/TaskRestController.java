package com.example.taskservice.web;

import com.example.taskservice.entities.Task;
import com.example.taskservice.feign.ProjectRestClient;
import com.example.taskservice.feign.ResourceRestClient;
import com.example.taskservice.repository.TaskRepository;
import com.example.taskservice.repository.TaskResourceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskRestController {
    private TaskRepository taskRepository;
    private TaskResourceRepository taskResourceRepository;
    private ProjectRestClient projectRestClient;
    private ResourceRestClient resourceRestClient;

    public TaskRestController(TaskRepository taskRepository,
                              TaskResourceRepository taskResourceRepository,
                              ProjectRestClient projectRestClient,
                              ResourceRestClient resourceRestClient) {

        this.taskRepository = taskRepository;
        this.taskResourceRepository = taskResourceRepository;
        this.projectRestClient = projectRestClient;
        this.resourceRestClient = resourceRestClient;
    }

    @GetMapping(path = "tsk/tasks/{id}")
    public Task getTask(@PathVariable Long id){
        Task task = taskRepository.findById(id).get();
        task.setProject(projectRestClient.getProjectById(task.getProjectId()));
        task.getTaskResources().forEach(taskResource -> {
            taskResource.setResource(resourceRestClient.getResourceById(taskResource.getResourceId()));
        });
        return task;
    }
}
