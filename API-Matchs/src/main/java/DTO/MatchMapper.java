package DTO;

import com.matchs.api.Model.Match;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MatchMapper {
    MatchMapper INSTANCE = Mappers.getMapper( MatchMapper.class );
    @Mapping(source = "resultat", target = "resultat")
    MatchDTO macthToMacthDto(Match macth);
}
