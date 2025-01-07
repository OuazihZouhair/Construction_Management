package com.example.taskservice.feign;

import com.example.taskservice.model.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "resource-service")
public interface ResourceRestClient {
    @GetMapping("/resources/{id}")
    Resource getResourceById(@PathVariable Long id);

    @GetMapping("/resources")
    PagedModel<Resource> getAllResources();

}
