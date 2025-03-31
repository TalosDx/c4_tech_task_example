package dev.example.tech_task.model.mapper;

import dev.example.tech_task.model.Example;
import dev.example.tech_task.model.dto.ExampleDto;
import org.springframework.stereotype.Component;


@Component
public class ExampleWithoutMapStructMapperImpl implements ExampleWithoutMapStructMapper {

    @Override
    public ExampleDto toDto(Example entity) {
        if (entity == null) {
            return null;
        }

        ExampleDto exampleDto = new ExampleDto();

        exampleDto.setId(entity.getId());
        exampleDto.setName(entity.getName());
        exampleDto.setDesc(entity.getDesc());

        return exampleDto;

    }

    @Override
    public Example toEntity(ExampleDto dto) {
        if (dto == null) {
            return null;
        }

        Example example = new Example();

        example.setId(dto.getId());
        example.setName(dto.getName());
        example.setDesc(dto.getDesc());

        return example;
    }
}
