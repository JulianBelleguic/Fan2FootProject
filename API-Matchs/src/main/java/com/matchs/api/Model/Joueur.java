package com.matchs.api.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "joueur")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)

public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_joueur", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_equipe")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Equipe equipe;

    @Column(length=30)
    @NotBlank(message = "Entrez un nom")
    @Size(min = 2, message = "Au moins 2 caractères")
    private String nom;

    @Column(length=30)
    @NotBlank(message = "Entrez un prénom")
    @Size(min = 2, message = "Au moins 2 caractères")
    private String prenom;

    @NotNull(message = "Entrez un age")
    @Min(value = 16, message = "Au moins 16")
    @Max(value = 65, message = "Au plus 65")
    private Integer age;


    @NotNull(message = "Entrez un score")
    @Min(value = 0, message = "Au moins 0")
    @Max(value = 99, message = "Au plus 99")
    private Integer score;

}
