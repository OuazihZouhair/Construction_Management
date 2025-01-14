package com.example.resourceservice.entities;

import com.example.resourceservice.enums.Type;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "needed", types = Resource.class)
public interface ResourceProjection {
    String getName();
    Type getType();
}
