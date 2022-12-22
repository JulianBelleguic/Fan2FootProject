package com.matchs.api.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "equipe")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipe_id", nullable = false, updatable = false)
    private Long id;

    @Column(length=50)
    private String nom;
    private Integer score;
//    @OneToMany(targetEntity = Joueurs.class, mappedBy = "equipe_id")
//    private List<Joueurs> joueurs;
//
    @OneToMany(targetEntity = Match.class, mappedBy = "id_equipe1")
    private List<Match> id_equipe1;

    @OneToMany(targetEntity = Match.class, mappedBy = "id_equipe2")
    private List<Match> id_equipe2;

    @OneToMany(targetEntity = Resultat.class, mappedBy = "id_resultat")
    private List<Resultat> id_resultat;


    public Equipe(Long id, String nom, Integer score, List<Match> id_equipe1, List<Match> id_equipe2, List<Resultat> id_resultat, List<Resultat> id_joueur) {
        this.id = id;
        this.nom = nom;
        this.score = score;
        this.id_equipe1 = id_equipe1;
        this.id_equipe2 = id_equipe2;
        this.id_resultat = id_resultat;
    }

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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<Match> getId_equipe1() {
        return id_equipe1;
    }

    public void setId_equipe1(List<Match> id_equipe1) {
        this.id_equipe1 = id_equipe1;
    }

    public List<Match> getId_equipe2() {
        return id_equipe2;
    }

    public void setId_equipe2(List<Match> id_equipe2) {
        this.id_equipe2 = id_equipe2;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", score=" + score +
                ", id_equipe1=" + id_equipe1 +
                ", id_equipe2=" + id_equipe2 +
                '}';
    }
}
