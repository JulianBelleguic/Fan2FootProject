package com.matchs.api.Service;

import com.matchs.api.Model.Equipe;
import com.matchs.api.Model.Match;
import com.matchs.api.Model.Resultat;
import com.matchs.api.Model.info_match;
import com.matchs.api.Repository.EquipeRepository;
import com.matchs.api.Repository.MatchRepository;
import com.matchs.api.Repository.ResultatRepository;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.List;


@Service
@Transactional
public class MatchService implements Serializable {
    // on crée l'attribut de class qui va contenir le repository
    private final MatchRepository matchRepository;
    private final EquipeService equipeService;
    private final ResultatRepository resultatRepository;

    public MatchService(MatchRepository matchRepository, EquipeService equipeService, ResultatRepository resultatRepository) {
        this.matchRepository = matchRepository;
        this.equipeService = equipeService;
        this.resultatRepository = resultatRepository;
    }

    public Match findMatch(Long id) {return this.matchRepository.findById(id).orElse(new Match(null, null,null,null));}

    public Match addMatch(Match model, Long idEquipe1, Long idEquipe2) {
        Match newMatch = this.matchRepository.save(model);
        Equipe eqp1 = equipeService.findEquipe(idEquipe1);
        Equipe eqp2 = equipeService.findEquipe(idEquipe2);
        if (newMatch.getId_equipe1()==null && model.getId_equipe2()==null){
            newMatch.setId_equipe1(eqp1);
            newMatch.setId_equipe2(eqp2);
        }
        this.matchRepository.save(newMatch);
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl  = "http://localhost:8081/Parie/add";
        Boolean response = restTemplate.getForObject(fooResourceUrl + "?idMatch=" + newMatch.getId_match() + "&scoreEqip1=" + eqp1.getScore() + "&scoreEqip2=" + eqp2.getScore(), Boolean.class);
        if (response){
            System.out.println("Pari créé.");
        }
        else{
            System.out.println("Erreur lors de la création du pari.");
        }
        return newMatch;
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
                resultat1.setId_equipe(equipe1);
                resultat2.setId_equipe(equipe2);
        }
        else if (score2>score1){
            resultat1.setResultat(0.0f);
            resultat2.setResultat(1.0f);
            resultat1.setId_equipe(equipe1);
            resultat2.setId_equipe(equipe2);
        }
        else{
            resultat1.setResultat(0.5f);
            resultat2.setResultat(0.5f);
            resultat1.setId_equipe(equipe1);
            resultat2.setId_equipe(equipe2);
        }
        this.equipeService.updScore(equipe1);
        this.equipeService.updScore(equipe2);

        resultatRepository.save(resultat1);
        resultatRepository.save(resultat2);

        return match;
    }

}