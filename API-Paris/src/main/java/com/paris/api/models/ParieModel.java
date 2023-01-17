package com.paris.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "parie")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ParieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_parie", nullable=false, updatable=false)
    private Long id;

    @NotNull(message = "idMatch is mandatory")
    @Column(length=30)
    private Long idMatch;

    @NotNull(message = "coteA is mandatory")
    @Column(name="coteA")
    private float coteA = 0;

    @NotNull(message = "coteB is mandatory")
    @Column(name="coteB")
    private float coteB = 0;

    @NotNull(message = "coteN is mandatory")
    @Column(name="coteN")
    private float coteN = 0;

}