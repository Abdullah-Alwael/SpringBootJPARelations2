package com.spring.boot.springbootjparelations2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    private Integer id;

    @NotEmpty(message = "name can not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String area;

    @NotEmpty(message = "name can not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String street;

    @NotEmpty(message = "name can not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
