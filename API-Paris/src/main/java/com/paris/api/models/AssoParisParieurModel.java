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
@AllArgsConstructor
@NoArgsConstructor

public class AssoParisParieurModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id", nullable=false, updatable=false)
    private Long id;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn(name="idParieur")
    private ParieurModel idParieur;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn(name="idParie")
    private ParieModel idParie;

    @Column(length=30)
    private Long idParis;

    @Column(length=30)
    private double montant;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn(name="idCote")
    private CoteModel idCote;


    @Column(length=30)
    private double gainPotentiel;

}