package com.matchs.api.Mapstruct.Mapper;

import com.matchs.api.Model.Joueur;
import com.matchs.api.Mapstruct.DTO.JoueurGetDto;
import com.matchs.api.Mapstruct.DTO.JoueurPostDto;
import org.mapstruct.Mapper;


@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

    JoueurGetDto JoueurToJoueurGetDto(Joueur joueur);

    Joueur JoueurPostDtoToUser(JoueurPostDto JoueurPostDto);
}