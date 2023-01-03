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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipe getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(Equipe id_equipe) {
        this.id_equipe = id_equipe;
    }

    public String getNom() {
        return nom;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return Objects.equals(id, joueur.id) && Objects.equals(id_equipe, joueur.id_equipe) && Objects.equals(nom, joueur.nom) && Objects.equals(prenom, joueur.prenom) && Objects.equals(age, joueur.age) && Objects.equals(score, joueur.score);
    }





}
