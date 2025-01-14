package com.example.projectservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "project.params")
public record ProjectConfigParams (int x, int y) {
}
