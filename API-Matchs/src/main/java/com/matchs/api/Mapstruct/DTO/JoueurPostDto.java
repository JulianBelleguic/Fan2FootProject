package com.matchs.api.Mapstruct.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.matchs.api.Model.Equipe;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoueurPostDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("id_equipe")
    private Equipe id_equipe;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("prenom")
    private String prenom;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("score")
    private Integer score;
}
