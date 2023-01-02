package com.matchs.api.Service;

import com.matchs.api.Model.Equipe;
import com.matchs.api.Model.Joueur;
import com.matchs.api.Repository.EquipeRepository;
import com.matchs.api.Repository.JoueurRepository;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class JoueurService implements Serializable{

    private final JoueurRepository repository;

    public JoueurService(JoueurRepository repository) {
        this.repository = repository;
    }

    public Joueur findJoueur(Long id) {
        return this.repository.findById(id).orElse(new Joueur(null, null, null, null, null, null));
    }

    public Joueur addJoueur(Joueur model) {
        return this.repository.save(model);
    }

    public void addEquipeToJoueur(Long joueurId, Equipe equipe){
        Joueur joueur = this.repository.getReferenceById(joueurId);
        joueur.setId_equipe(equipe);
        this.repository.save(joueur);
    }

}
