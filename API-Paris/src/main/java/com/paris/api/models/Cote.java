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
@AllArgsConstructor
@NoArgsConstructor

public class Cote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="idCote", nullable=false, updatable=false)
    private Long id;

    @Column(length=30)
    private double valeur;


}