package dev.example.tech_task.model.mapper;

import dev.example.tech_task.model.Example;
import dev.example.tech_task.model.dto.ExampleDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;


public interface ExampleWithoutMapStructMapper {

     ExampleDto toDto(Example entity);

     Example toEntity(ExampleDto dto);
}
