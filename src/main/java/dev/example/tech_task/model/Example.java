package dev.example.tech_task.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "example")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "desc")
    private String desc;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Example example)) return false;

        return Objects.equals(id, example.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Example{" +
                "id=" + id +
                '}';
    }
}
