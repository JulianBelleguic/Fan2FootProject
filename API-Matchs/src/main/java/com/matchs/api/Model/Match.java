package com.matchs.api.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "matchs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id", nullable = false, updatable = false)
    private Long id_match;

    @ManyToOne
    private Equipe id_equipe1;

    @ManyToOne
    private Equipe id_equipe2;

}
