package com.paris.api.models;

import jakarta.persistence.*;
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

    @Column(length=30)
    private String nom;

    @Column(length=30)
    private String prenom;

    @Column(length=30)
    private double balance;

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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}