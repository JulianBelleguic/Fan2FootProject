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
    @OneToOne(targetEntity = Resultat.class, mappedBy = "id_match", cascade = CascadeType.REMOVE)
    private Long id_match;

    @Column(name="resultat", length = 5)
    private String resultat;

    @ManyToOne
    private Equipe id_equipe1;

    @ManyToOne
    private Equipe id_equipe2;


}
