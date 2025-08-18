package com.spring.boot.springbootjparelations2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name can not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @NotNull(message = "age can not be empty")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "name can not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
