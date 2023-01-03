package com.paris.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cote")
@Getter
@Setter

public class CoteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="idCote", nullable=false, updatable=false)
    private Long id;

    @Column(length=30)
    private double valeur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public CoteModel(Long id, double valeur) {
        this.id = id;
        this.valeur = valeur;

    }
    public CoteModel() {
    }
}