package com.example.project;

import Utils.ConvertRelationship;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectApplication {

    @Bean
    public ConvertRelationship convertRelationship(){
        return new ConvertRelationship();
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }
}