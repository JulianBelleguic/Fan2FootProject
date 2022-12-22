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
@AllArgsConstructor
@NoArgsConstructor

public class Parieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="idParieur", nullable=false, updatable=false)
    private Long id;

    @Column(length=30)
    private String nom;

    @Column(length=30)
    private String prenom;

}