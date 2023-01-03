package com.matchs.api.Service;

import com.matchs.api.Model.Equipe;
import com.matchs.api.Repository.EquipeRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class EquipeService implements Serializable {
    // on crée l'attribut de class qui va contenir le repository
    private final EquipeRepository equipeRepository;

    // on propose un constructeur, qui va recevoir une instance du repository fournie automatiquement par Spring
    public EquipeService(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
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
}