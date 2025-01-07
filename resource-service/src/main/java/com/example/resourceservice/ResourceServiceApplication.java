package com.example.resourceservice;

import com.example.resourceservice.entities.Resource;
import com.example.resourceservice.enums.Type;
import com.example.resourceservice.repository.ResourceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResourceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ResourceRepository resourceRepository){
        return args -> {
            Resource resource = new Resource("Resource1",
                    Type.MATERIAL,
                    1000,
                    "Supplier1");

            resourceRepository.save(resource);

            System.out.println("==========================");
            System.out.println(resource.getName());
            System.out.println("==========================");
        };
    }
}
