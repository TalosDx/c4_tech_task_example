package dev.example.tech_task.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.context.annotation.Description;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExampleDto {

    @JsonProperty("id")
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 36)
    @JsonProperty("name")
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 256)
    @JsonProperty("desc")
    private String desc;
}
