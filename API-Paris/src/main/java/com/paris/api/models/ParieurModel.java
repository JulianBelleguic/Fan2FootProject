package com.paris.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "parieur")
@Getter
@Setter
@NoArgsConstructor

public class ParieurModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="idParieur", nullable=false, updatable=false)
    private Long id;

    @Column(length=30)
    private String nom;

    @Column(length=30)
    private String prenom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public ParieurModel(Long id, String nom, String prenom){this.id = id; this.nom = nom; this.prenom = prenom;}

}