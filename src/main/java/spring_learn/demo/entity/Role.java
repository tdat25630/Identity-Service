package spring_learn.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String name;
    private String description;

    @ManyToMany
    Set<Permission> permissions;


}
