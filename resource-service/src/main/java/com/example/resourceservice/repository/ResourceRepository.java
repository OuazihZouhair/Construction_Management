package com.example.resourceservice.repository;

import com.example.resourceservice.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
