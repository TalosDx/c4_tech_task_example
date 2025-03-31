package dev.example.tech_task.controller;

import dev.example.tech_task.model.dto.ExampleDto;
import dev.example.tech_task.model.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/examples")
@RequiredArgsConstructor
public class ExampleController {
    private final ExampleService service;


    @GetMapping("/")
    public Page<ExampleDto> getAll(Pageable pageable) {
        return service.getAll(pageable);
    }

    @GetMapping("/{id}")
    public ExampleDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/")
    public ExampleDto create(@Validated @RequestBody ExampleDto request) {
        //validations валидацию осуществляет @Validated

        return service.create(request);
    }


    @PutMapping("/{id}")
    public ExampleDto update(@PathVariable Long id, @Validated @RequestBody ExampleDto request) {
        //validations
        if(id == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id in Path empty or null");

        request.setId(id);

        return service.update(request);
    }

    @PatchMapping("/{id}")
    public ExampleDto updatePartially(@PathVariable Long id, @Validated @RequestBody ExampleDto request) {
        //validations

        if(id == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id in Path empty or null");

        request.setId(id);

        return service.partialUpdate(request);
    }
}
