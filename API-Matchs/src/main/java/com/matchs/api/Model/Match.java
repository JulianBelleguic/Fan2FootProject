package com.matchs.api.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "matchs")
@NoArgsConstructor
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
