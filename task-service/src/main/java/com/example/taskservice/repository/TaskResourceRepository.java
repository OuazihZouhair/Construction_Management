package com.example.taskservice.repository;

import com.example.taskservice.entities.TaskResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface TaskResourceRepository extends JpaRepository<TaskResource, Long> {
}
