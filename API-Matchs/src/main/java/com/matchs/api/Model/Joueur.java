package com.matchs.api.Model;

import jakarta.persistence.*;
import lombok.*;

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

}
