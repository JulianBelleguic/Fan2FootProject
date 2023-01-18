package com.paris.api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "parieur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ParieurModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_parieur", nullable=false, updatable=false)
    private Long id;

    @NotBlank(message = "nom ne doit pas être vide")
    @Column(length=30)
    private String nom;

    @NotBlank(message = "prenom ne doit pas être vide")
    @Column(length=30)
    private String prenom;

    @NotNull(message = "balance is mandatory")
    private double balance;

}