package com.matchs.api.Service;

import com.matchs.api.Model.Equipe;
import com.matchs.api.Model.Resultat;
import com.matchs.api.Repository.EquipeRepository;
import com.matchs.api.Repository.ResultatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class EquipeService implements Serializable {
    // on crée l'attribut de class qui va contenir le repository
    private final EquipeRepository equipeRepository;
    private final ResultatRepository resultatRepository;

    @Autowired
    // on propose un constructeur, qui va recevoir une instance du repository fournie automatiquement par Spring
    public EquipeService(EquipeRepository equipeRepository, ResultatRepository resultatRepository) {
        this.equipeRepository = equipeRepository;
        this.resultatRepository = resultatRepository;
    }

    public List<Equipe> findAllEquipes() { return equipeRepository.findAll(); }

    public Equipe findEquipe(Long id) {
        return this.equipeRepository.findById(id).orElse(new Equipe(null, null, null, null, null, null));
    }

    public Equipe addEquipe(Equipe model) {
        return this.equipeRepository.save(model);
    }

    public Equipe updEquipe(Equipe model) {
        return this.equipeRepository.save(model);
    }

    public void delEquipe(Long id) {
        this.equipeRepository.deleteById(id);
    }

    public void updScore(Equipe equipe) {
        Float listresultats;
        listresultats = this.resultatRepository.findResulats(equipe.getId());
        System.out.println(listresultats);
    }
}