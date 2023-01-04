package com.matchs.api.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "joueur")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_joueur", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    private Equipe id_equipe;

    @Column(length=30)
    private String nom;

    @Column(length=30)
    private String prenom;

    private Integer age;

    private Integer score;


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Joueur joueur = (Joueur) o;
//        return Objects.equals(id, joueur.id) && Objects.equals(id_equipe, joueur.id_equipe) && Objects.equals(nom, joueur.nom) && Objects.equals(prenom, joueur.prenom) && Objects.equals(age, joueur.age) && Objects.equals(score, joueur.score);
//    }





}
