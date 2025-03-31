package dev.example.tech_task.model.mapper;

import dev.example.tech_task.model.Example;
import dev.example.tech_task.model.dto.ExampleDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ExampleMapper {


    ExampleDto toDto(Example entity);

    Example toEntity(ExampleDto dto);

    Example update(@MappingTarget Example entity, ExampleDto dto);
}
