package com.matchs.api.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class info_match {

    private Long id_match;

    private String nom_eq1;

    private String nom_eq2;

    private Float score_eq1;

    private Float score_eq2;

    public info_match(Long id_match, String nom_eq1, String nom_eq2, Float score_eq1, Float score_eq2) {
        this.id_match = id_match;
        this.nom_eq1 = nom_eq1;
        this.nom_eq2 = nom_eq2;
        this.score_eq1 = score_eq1;
        this.score_eq2 = score_eq2;
    }
}
