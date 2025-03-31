package dev.example.tech_task;

import org.springframework.boot.SpringApplication;

public class TestTechTaskApplication {

    public static void main(String[] args) {
        SpringApplication.from(TechTaskApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
