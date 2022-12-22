package com.matchs.api.Service;

import com.matchs.api.Model.Equipe;
import com.matchs.api.Repository.EquipeRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class EquipeService implements Serializable {
    // on crée l'attribut de class qui va contenir le repository
    private final EquipeRepository repository;

    // on propose un constructeur, qui va recevoir une instance du repository fournie automatiquement par Spring
    public EquipeService(EquipeRepository repository) {
        this.repository = repository;
    }

    public Equipe findEquipe(Long id) {
        return this.repository.findById(id).orElse(new Equipe(null, null));
    }

    public Equipe addEquipe(Equipe model) {
        return this.repository.save(model);
    }

    public Equipe updEquipe(Equipe model) {
        return this.repository.save(model);
    }

    public void delEquipe(Long id) {
        this.repository.deleteById(id);
    }
}