package com.intercorp.DataStorageService.infrastructure.dataaccess;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "root")
@NoArgsConstructor
@AllArgsConstructor
public class RootEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    @OneToOne(cascade = CascadeType.ALL)
    private PersonEntity person;
    private Integer random;
    private Float random_float;
    private Boolean bool;
    private LocalDate date;
    private String regEx;
    private String enumValue;
    private String elt;
    private String root_id;


}