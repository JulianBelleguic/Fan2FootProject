package com.paris.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class info_match implements Serializable {

    private Long id_match;

    private String nom_eq1;

    private String nom_eq2;

    private Integer score_eq1;

    private Integer score_eq2;

}
