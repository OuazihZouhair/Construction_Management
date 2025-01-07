package com.example.taskservice.feign;

import com.example.taskservice.model.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "project-service")
public interface ProjectRestClient {
    @GetMapping("/projects/{id}")
    Project getProjectById(@PathVariable Long id);

    @GetMapping("/projects")
    PagedModel<Project> getAllProjects();
}
