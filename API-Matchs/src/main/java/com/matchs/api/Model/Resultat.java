package com.matchs.api.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

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

    @OneToOne
    private Match id_match;
}