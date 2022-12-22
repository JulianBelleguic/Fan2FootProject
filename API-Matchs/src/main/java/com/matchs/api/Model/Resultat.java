package com.matchs.api.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "resultat")
@NoArgsConstructor
@AllArgsConstructor
public class Resultat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resultat", nullable = false, updatable = false)
    private long id_resultat;

    @ManyToOne
    private Equipe id_equipe;
}