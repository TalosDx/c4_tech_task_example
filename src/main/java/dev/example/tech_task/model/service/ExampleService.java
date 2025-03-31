package dev.example.tech_task.model.service;

import dev.example.tech_task.model.Example;
import dev.example.tech_task.model.dto.ExampleDto;
import dev.example.tech_task.model.mapper.ExampleMapper;
import dev.example.tech_task.model.repository.ExampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ExampleService {
    private final ExampleRepository repository;
    private final ExampleMapper mapper;


    public Page<ExampleDto> getAll(Pageable pageable) {
        Page<Example> page = repository.findAll(pageable);

        List<ExampleDto> dtos = page
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());


        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }

    public ExampleDto getById(Long id) {
        return mapper.toDto(
                repository.getReferenceById(id)
        );
    }

    public ExampleDto create(ExampleDto request) {
        Example saved = repository.save(
                mapper.toEntity(request)
        );

        return mapper.toDto(saved);
    }

    public ExampleDto update(ExampleDto request) {
        Example entity = repository.getReferenceById(request.getId());

        entity = repository.save(mapper.update(entity, request));
        return mapper.toDto(entity);
    }

    public ExampleDto partialUpdate(ExampleDto request) {
        Example entity = repository.getReferenceById(request.getId());

        entity = repository.save(mapper.update(entity, request));
        return mapper.toDto(entity);
    }
}
