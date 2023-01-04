package com.matchs.api.Service;

import com.matchs.api.Model.Equipe;
import com.matchs.api.Model.Match;
import com.matchs.api.Model.info_match;
import com.matchs.api.Repository.EquipeRepository;
import com.matchs.api.Repository.MatchRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;


@Service
@Transactional
public class MatchService implements Serializable {
    // on crée l'attribut de class qui va contenir le repository
    private MatchRepository matchRepository;
    private EquipeService equipeService;

    public MatchService(MatchRepository matchRepository, EquipeRepository equipeRepository, EquipeService equipeService) {
        this.matchRepository = matchRepository;
        this.equipeService = equipeService;

    }

    public Match findMatch(Long id) {return this.matchRepository.findById(id).orElse(new Match(null, null,null,null));}

    public Match addMatchById(Match model, Long id_equipe1, Long id_equipe2) {
        Match new_match = this.matchRepository.save(model);
        Equipe eqp1 = equipeService.findEquipe(id_equipe1);
        Equipe eqp2 = equipeService.findEquipe(id_equipe2);
        if (new_match.getId_equipe1()==null && model.getId_equipe2()==null){
            new_match.setId_equipe1(eqp1);
            new_match.setId_equipe2(eqp2);
        }
        return this.matchRepository.save(new_match);
    }

    public Match addMatch(Match model) {
        return this.matchRepository.save(model);
    }

    public Match updMatch(Match model) {
        return this.matchRepository.save(model);
    }

    public void delMatch(Long id) {
        this.matchRepository.deleteById(id);
    }

    public Match addResultat(Long id, String Result){
        Match match = findMatch(id);
        match.setResultat(Result);
        return this.matchRepository.save(match);
    }

    public info_match envoiScores(Long id) {
        Match game = findMatch(id);
        info_match infomatch = new info_match(null, null, null, null, null);
        infomatch.setId_match(id);
        infomatch.setNom_eq1(game.getId_equipe1().getNom());
        infomatch.setNom_eq2(game.getId_equipe2().getNom());
        infomatch.setScore_eq1(game.getId_equipe1().getScore());
        infomatch.setScore_eq2(game.getId_equipe2().getScore());
        return infomatch;
    }
}