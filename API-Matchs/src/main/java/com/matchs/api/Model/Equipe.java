package com.matchs.api.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "equipe")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipe_id", nullable = false, updatable = false)
    private Long id;

    @Column(length=50)
    private String nom;
    private Integer score;

    @OneToMany(targetEntity = Match.class, mappedBy = "id_equipe1")
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Match> id_equipe1 = new ArrayList<>();

    @OneToMany(targetEntity = Match.class, mappedBy = "id_equipe2")
    @ToString.Exclude
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    private List<Match> id_equipe2 = new ArrayList<>();

    @OneToMany(targetEntity = Resultat.class, mappedBy = "id_resultat")
    private List<Resultat> id_resultat;

 }
