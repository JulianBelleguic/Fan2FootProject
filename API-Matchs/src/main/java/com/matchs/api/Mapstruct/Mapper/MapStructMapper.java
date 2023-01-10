package com.matchs.api.Mapstruct.Mapper;

import com.matchs.api.Mapstruct.DTO.EquipeSlimDto;
import com.matchs.api.Mapstruct.DTO.JoueurSlimDto;
import com.matchs.api.Mapstruct.DTO.MatchGetDto;
import com.matchs.api.Mapstruct.DTO.ResultatSlimDto;
import com.matchs.api.Model.Equipe;
import com.matchs.api.Model.Joueur;
import com.matchs.api.Model.Match;
import com.matchs.api.Model.Resultat;
import org.mapstruct.Mapper;


@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

    MatchGetDto MatchtoMatchGetDto(Match match);

    EquipeSlimDto EquipeToEquipeDto(Equipe equipe);

    JoueurSlimDto JoueurToJoueurDto(Joueur joueur);

    ResultatSlimDto ResultatToResultatDto(Resultat resultat);
}