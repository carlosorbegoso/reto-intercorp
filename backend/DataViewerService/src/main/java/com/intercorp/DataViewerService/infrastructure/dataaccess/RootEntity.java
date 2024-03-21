package com.intercorp.DataViewerService.infrastructure.dataaccess;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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
    private String rootId;


}