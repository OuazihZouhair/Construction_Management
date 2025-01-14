package com.example.projectservice;

import com.example.projectservice.config.ProjectConfigParams;
import com.example.projectservice.entities.Project;
import com.example.projectservice.repository.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
@EnableConfigurationProperties(ProjectConfigParams.class)
public class ProjectServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProjectRepository projectRepository){
        return args -> {
            Project project1 = new Project("Project1", "Description2", LocalDate.of(2024, 12, 24),
                    LocalDate.of(2025, 12, 10),
                    new BigDecimal("1000000.00"));

            Project project2 = new Project("Project2", "Description2", LocalDate.of(2024, 12, 24),
                    LocalDate.of(2025, 12, 10),
                    new BigDecimal("2000000.00"));

            Project project3 = new Project("Project3", "Description3", LocalDate.of(2024, 12, 24),
                    LocalDate.of(2025, 12, 10),
                    new BigDecimal("3000000.00"));

            projectRepository.save(project1);
            projectRepository.save(project2);
            projectRepository.save(project3);


            projectRepository.findAll().forEach(p->{
                System.out.println("=========================");
                System.out.println(p.getName());
                System.out.println(p.getBudget());
                System.out.println("=========================");
            });
        };
    }

}
