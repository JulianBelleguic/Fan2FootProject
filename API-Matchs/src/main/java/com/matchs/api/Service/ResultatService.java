package com.matchs.api.Service;

import com.matchs.api.Model.Resultat;
import com.matchs.api.Repository.ResultatRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class ResultatService implements Serializable {
    // on crée l'attribut de class qui va contenir le repository
    private final ResultatRepository repository;

    // on propose un constructeur, qui va recevoir une instance du repository fournie automatiquement par Spring
    public ResultatService(ResultatRepository repository) {
        this.repository = repository;
    }

    public Resultat findResultat(Long id) {
        return this.repository.findById(id).orElse(new Resultat(null, null, null));
    }

    public Resultat addResultat(Resultat model) {
        return this.repository.save(model);
    }

    public Resultat updResultat(Resultat model) {
        return this.repository.save(model);
    }

    public void delResultat(Long id) {
        this.repository.deleteById(id);
    }
}