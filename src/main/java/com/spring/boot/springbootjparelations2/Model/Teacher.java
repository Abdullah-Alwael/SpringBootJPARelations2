package com.spring.boot.springbootjparelations2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name can not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @NotNull(message = "age can not be empty")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "email can not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String email;

    @NotNull(message = "salary can not be empty")
    @Column(columnDefinition = "double not null")
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses;
}
