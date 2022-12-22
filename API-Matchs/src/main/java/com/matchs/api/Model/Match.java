package com.matchs.api.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Table(name= "match")
@AllArgsConstructor
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id", nullable = false, updatable = false)
    private long id_match;

    @ManyToOne
    private Equipe id_equipe1;

    @ManyToOne
    private Equipe id_equipe2;


}
