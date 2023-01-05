package com.matchs.api.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "resultat")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Resultat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resultat", nullable = false, updatable = false)
    private Long id_resultat;

    @Column(name = "resultat")
    private Float resultat;

    @ManyToOne
    private Equipe id_equipe;
}