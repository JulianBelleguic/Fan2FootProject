package com.matchs.api.Model;

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
    @JoinColumn(name = "id_equipe")
    private Equipe id_equipe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id")
    @ToString.Exclude
    private Match id_match;
}