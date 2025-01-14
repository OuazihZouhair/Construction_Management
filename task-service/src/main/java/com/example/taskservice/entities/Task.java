package com.example.taskservice.entities;

import com.example.taskservice.enums.Status;
import com.example.taskservice.model.Project;
import com.example.taskservice.model.Resource;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Long projectId;
    @OneToMany(mappedBy = "task")
    private List<TaskResource> taskResources = new ArrayList<>();

    @Transient
    private Project project;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Task() {
    }

    public Task(String description, LocalDate startDate, LocalDate endDate, Status status, Long projectId) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.projectId = projectId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<TaskResource> getTaskResources() {
        return taskResources;
    }

    public void setTaskResources(List<TaskResource> taskResources) {
        this.taskResources = taskResources;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
