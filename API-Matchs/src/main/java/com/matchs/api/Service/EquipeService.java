package com.matchs.api.Service;

import com.github.javafaker.Faker;
import com.matchs.api.Model.Equipe;
import com.matchs.api.Model.Joueur;
import com.matchs.api.Model.Resultat;
import com.matchs.api.Repository.EquipeRepository;
import com.matchs.api.Repository.ResultatRepository;
import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

@Service
public class EquipeService implements Serializable {
    // on crée l'attribut de class qui va contenir le repository
    private final EquipeRepository equipeRepository;
    private final ResultatService resultatService;

    private final ResultatRepository resultatRepository;

    @Autowired
    // on propose un constructeur, qui va recevoir une instance du repository fournie automatiquement par Spring
    public EquipeService(EquipeRepository equipeRepository, ResultatService resultatService, ResultatRepository resultatRepository) {
        this.equipeRepository = equipeRepository;
        this.resultatService = resultatService;
        this.resultatRepository = resultatRepository;
    }

    public List<Equipe> findAllEquipes() { return equipeRepository.findAll(); }

    public Equipe findEquipe(Long id) {
        return this.equipeRepository.findById(id).orElse(new Equipe(null, null, null, null, null, null));
    }

    @Deprecated
    public Equipe createRandomEquipe() {
        Faker faker = new Faker(new Locale("fr-FR"));
        Equipe equipe = new Equipe();
        equipe.setNom(faker.address().cityName());
        equipe.setScore(Precision.round((float) ((Math.random() * 100) + 0), 2));
        return equipe;
    }

    public Equipe addEquipe(Equipe model) {
        this.equipeRepository.save(model);
        for (int i = 0; i < 10; i++) {
            Resultat resultat = new Resultat();
            resultat.setResultat(0.5F);
            resultat.setId_equipe(model);
            System.out.println(resultat);
            this.resultatService.addResultat(resultat);
        }
        return model;
    }

    public Equipe updEquipe(Equipe model) {
        return this.equipeRepository.save(model);
    }

    public void delEquipe(Long id) {
        this.equipeRepository.deleteById(id);
    }

    public void updScore(Equipe equipe) {
        Float sommeResultats;
        sommeResultats = this.resultatRepository.findResulats(equipe.getId());
        float score = equipe.getScore();
        float variation;
        if (sommeResultats > 5) {
            variation = (float) (2 * (sommeResultats - 5) * (0.001) * (100 - score));
            score = Precision.round(score + variation,2);
        }
        if (sommeResultats < 5) {
            variation = (float) (2 * (sommeResultats - 5) * (0.001) * (score));
            score = Precision.round(score + variation,2);
        }
        equipe.setScore(score);
    }
}