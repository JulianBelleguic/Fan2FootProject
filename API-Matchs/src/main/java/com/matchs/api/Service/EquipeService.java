package com.matchs.api.Service;

import com.github.javafaker.Faker;
import com.matchs.api.Model.Equipe;
import com.matchs.api.Model.Joueur;
import com.matchs.api.Model.Resultat;
import com.matchs.api.Repository.EquipeRepository;
import com.matchs.api.Repository.JoueurRepository;
import com.matchs.api.Repository.ResultatRepository;
import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class EquipeService implements Serializable {
    // on crée l'attribut de class qui va contenir le repository
    private final EquipeRepository equipeRepository;
    private final ResultatService resultatService;

    private final ResultatRepository resultatRepository;

    private final JoueurService joueurService;
    private final JoueurRepository joueurRepository;

    @Autowired
    // on propose un constructeur, qui va recevoir une instance du repository fournie automatiquement par Spring
    public EquipeService(EquipeRepository equipeRepository, ResultatService resultatService, ResultatRepository resultatRepository, JoueurService joueurService, JoueurRepository joueurRepository) {
        this.equipeRepository = equipeRepository;
        this.resultatService = resultatService;
        this.resultatRepository = resultatRepository;
        this.joueurService = joueurService;
        this.joueurRepository = joueurRepository;
    }

    public List<Equipe> findAllEquipes() { return equipeRepository.findAll(); }

    public Equipe findEquipe(Long id) {
        return this.equipeRepository.findById(id).orElse(new Equipe(null, null, null, null, null, null, null));
    }

    public boolean addEquipeToJoueur(Long joueurId, Long id_equipe){
        if (!joueurRepository.existsById(joueurId) || !equipeRepository.existsById(id_equipe)){
            return false;
        }
        else {
            Joueur joueur = joueurService.findJoueur(joueurId);
            joueur.setEquipe(findEquipe(id_equipe));
            joueurRepository.save(joueur);
            return true;
        }
    }

    @Deprecated
    public Equipe createRandomEquipe() {
        Faker faker = new Faker(new Locale("fr-FR"));
        Equipe equipe = new Equipe();
        equipe.setNom(faker.address().cityName());
        equipe.setScore(Precision.round((float) ((Math.random() * 100) + 0), 2));
        return equipe;
    }

    public Equipe createRandomFUllEquipe() {
        Equipe equipe = addEquipe(createRandomEquipe());
        for (int i = 0; i < 11; i++) {
            Joueur joueur = joueurService.createRandomJoueur();
            joueur.setEquipe(equipe);
            joueurService.addJoueur(joueur);
        }
        return equipe;
    }

    public ArrayList<Equipe> createMultipleEquipe(Integer n) {
        ArrayList<Equipe> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Equipe newEquipe = addEquipe(createRandomFUllEquipe());
            list.add(newEquipe);
        }
        return list;
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

    public void updEquipe(Equipe model) {
        this.equipeRepository.save(model);
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