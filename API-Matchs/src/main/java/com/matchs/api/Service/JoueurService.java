package com.matchs.api.Service;

import com.matchs.api.Model.Equipe;
import com.matchs.api.Model.Joueur;
import com.matchs.api.Repository.JoueurRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
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

    public boolean addEquipeToJoueur(Long joueurId, Equipe equipe){
        Joueur joueur = this.repository.getReferenceById(joueurId);
        joueur.setId_equipe(equipe);
        Joueur rep = this.repository.save(joueur);
        if (rep == null){
            return false;
        }else {
            return true;
        }
    }

}
