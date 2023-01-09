package com.matchs.api.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "joueur")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_joueur", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    private Equipe id_equipe;

    @NotBlank(message = "Name is mandatory")
    @Column(length=30)
    private String nom;

    @NotBlank(message = "Name is mandatory")
    @Column(length=30)
    private String prenom;

    @Min(18)
    @Max(80)
    private Integer age;

    private Integer score;

}
