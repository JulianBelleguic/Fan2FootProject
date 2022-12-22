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

public class Parie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="idParie", nullable=false, updatable=false)
    private Long id;

    @Column(length=30)
    private Long idMatch;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn(name="idCoteA")
    private Cote idCoteA;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn(name="idCoteB")
    private Cote idCoteB;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn(name="idCoteN")
    private Cote idCoteN;
}