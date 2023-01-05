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

    @Column(name="idParieur", nullable=false, updatable=false)
    private Long id;

    @Column(length=30)
    private String nom;

    @Column(length=30)
    private String prenom;

}