package com.paris.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "assoPariParieur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AssoParisParieurModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id", nullable=false, updatable=false)
    private Long id;

    @Column(length=30)
    private Long idParieur;

    @Column(length=30)
    private Long idParis;

    @Column(length=30)
    private double montant;


    @Column(name="coteChoisie", length = 1)
    private String coteChoisie;


    @Column(length=30)
    private double gainPotentiel;


}