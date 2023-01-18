package com.matchs.api.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "id_match", nullable = false, updatable = false)
    private Long id_match;

    @Column(name="resultat", length = 5)
    private String resultat;

    @ManyToOne
    @JoinColumn(name = "id_equipe1")
    private Equipe id_equipe1;

    @ManyToOne
    @JoinColumn(name = "id_equipe2")
    private Equipe id_equipe2;

    @OneToMany(mappedBy = "id_match", cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Resultat> resultats;
}
