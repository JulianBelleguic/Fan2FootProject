package com.matchs.api.Service;

import com.matchs.api.Model.Equipe;
import com.matchs.api.Model.Match;
import com.matchs.api.Model.Resultat;
import com.matchs.api.Model.info_match;
import com.matchs.api.Repository.EquipeRepository;
import com.matchs.api.Repository.MatchRepository;
import com.matchs.api.Repository.ResultatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


@Service
@Transactional
public class MatchService implements Serializable {
    // on crée l'attribut de class qui va contenir le repository
    private MatchRepository matchRepository;
    private EquipeService equipeService;
    private ResultatRepository resultatRepository;

    public MatchService(MatchRepository matchRepository, EquipeService equipeService, ResultatRepository resultatRepository) {
        this.matchRepository = matchRepository;
        this.equipeService = equipeService;
        this.resultatRepository = resultatRepository;
    }

    public Match findMatch(Long id) {return this.matchRepository.findById(id).orElse(new Match(null, null,null,null));}

    public Match addMatch(Match model, Long id_equipe1, Long id_equipe2) {
        Match new_match = this.matchRepository.save(model);
        Equipe eqp1 = equipeService.findEquipe(id_equipe1);
        Equipe eqp2 = equipeService.findEquipe(id_equipe2);
        if (new_match.getId_equipe1()==null && model.getId_equipe2()==null){
            new_match.setId_equipe1(eqp1);
            new_match.setId_equipe2(eqp2);
        }
        return this.matchRepository.save(new_match);
    }

//    public Match addMatch(Match model) {
//        return this.matchRepository.save(model);
//    }

    public Match updMatch(Match model) {
        return this.matchRepository.save(model);
    }

    public void delMatch(Long id) {
        this.matchRepository.deleteById(id);
    }

    public Match addResultat(Long id, String Result){
        Match match = findMatch(id);
        match.setResultat(Result);
        this.matchRepository.save(match);
        Equipe equipe1 = equipeService.findEquipe(match.getId_equipe1().getId());
        Equipe equipe2 = equipeService.findEquipe(match.getId_equipe2().getId());
        Resultat resultat1 = new Resultat(null,null,null);
        Resultat resultat2 = new Resultat(null,null,null);
        String[] scinde = Result.split("-");
        int score1 = Integer.parseInt(scinde[0]);
        int score2 = Integer.parseInt(scinde[1]);
        if (score1>score2){
                resultat1.setResultat(1.0f);
                resultat2.setResultat(0.0f);
                resultat1.setId_resultat(match.getId_equipe1().getId());
                resultat2.setId_resultat(match.getId_equipe2().getId());
                resultat1.setId_equipe(equipe1);
                resultat2.setId_equipe(equipe2);
        }
        else if (score2>score1){
            resultat1.setResultat(0.0f);
            resultat2.setResultat(1.0f);
            resultat1.setId_resultat(match.getId_equipe1().getId());
            resultat2.setId_resultat(match.getId_equipe2().getId());
            resultat1.setId_equipe(equipe1);
            resultat2.setId_equipe(equipe2);
        }
        else{
            resultat1.setResultat(0.5f);
            resultat2.setResultat(0.5f);
            resultat1.setId_resultat(match.getId_equipe1().getId());
            resultat2.setId_resultat(match.getId_equipe2().getId());
            resultat1.setId_equipe(equipe1);
            resultat2.setId_equipe(equipe2);
        }
        resultatRepository.save(resultat1);
        resultatRepository.save(resultat2);
        return match;
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