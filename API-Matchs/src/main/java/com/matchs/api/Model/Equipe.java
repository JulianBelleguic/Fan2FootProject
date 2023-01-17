package com.matchs.api.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "equipe")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)

public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipe_id", nullable = false, updatable = false)
    private Long id;

    @Column(length=50)
    private String nom;
    private Float score;

    @OneToMany(targetEntity = Match.class, mappedBy = "id_equipe1", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ToString.Exclude
    private List<Match> id_equipe1 = new ArrayList<>();

    @OneToMany(targetEntity = Match.class, mappedBy = "id_equipe2", cascade = CascadeType.ALL)
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    @ToString.Exclude
    private List<Match> id_equipe2 = new ArrayList<>();

    @OneToMany(targetEntity = Resultat.class, mappedBy = "id_equipe", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ToString.Exclude
    private List<Resultat> id_equipe = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Joueur.class, mappedBy = "equipe")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Joueur> list_joueurs = new ArrayList<>();

 }
