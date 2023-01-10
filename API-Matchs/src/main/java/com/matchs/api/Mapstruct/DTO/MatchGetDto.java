package com.matchs.api.Mapstruct.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.matchs.api.Model.Equipe;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchGetDto {

    @JsonProperty("id_match")
    private Long id_match;

    @JsonProperty("id_equipe1")
    private EquipeSlimDto id_equipe1;

    @JsonProperty("id_equipe2")
    private EquipeSlimDto id_equipe2;
}
