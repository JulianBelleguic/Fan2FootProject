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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParieurModel getIdParieur() {
        return idParieur;
    }

    public void setIdParieur(ParieurModel idParieur) {
        this.idParieur = idParieur;
    }

    public ParieModel getIdParie() {
        return idParie;
    }

    public void setIdParie(ParieModel idParie) {
        this.idParie = idParie;
    }

    public Long getIdParis() {
        return idParis;
    }

    public void setIdParis(Long idParis) {
        this.idParis = idParis;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public CoteModel getIdCote() {
        return idCote;
    }

    public void setIdCote(CoteModel idCote) {
        this.idCote = idCote;
    }

    public double getGainPotentiel() {
        return gainPotentiel;
    }

    public void setGainPotentiel(double gainPotentiel) {
        this.gainPotentiel = gainPotentiel;
    }

    public AssoParisParieurModel(Long id, ParieurModel idParieur, ParieModel idParie, double montant, CoteModel idCote, double gainPotentiel) {
        this.id = id;
        this.idParieur = idParieur;
        this.montant = montant;
        this.idParie = idParie;
        this.idCote = idCote;
        this.gainPotentiel = gainPotentiel;

    }

}