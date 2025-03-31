package dev.example.tech_task.model.repository;

import dev.example.tech_task.model.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExampleRepository extends JpaRepository<Example, Long> {

    List<Example> findAllByName(String name);
}
