package com.paris.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "parie")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ParieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_parie", nullable=false, updatable=false)
    private Long id;

    @Column(length=30)
    private Long idMatch;

    @Column(name="coteA")
    private float CoteA = 0;

    @Column(name="coteB")
    private float CoteB = 0;

    @Column(name="coteN")
    private float CoteN = 0;

    public double getCoteA() {
        return CoteA;
    }

    public double getCoteB() {
        return CoteB;
    }

    public double getCoteN() {
        return CoteN;
    }
}