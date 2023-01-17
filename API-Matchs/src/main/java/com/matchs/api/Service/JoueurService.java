package com.matchs.api.Service;

import com.github.javafaker.Faker;
import com.matchs.api.Model.Equipe;
import com.matchs.api.Model.Joueur;
import com.matchs.api.Repository.EquipeRepository;
import com.matchs.api.Repository.JoueurRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

@Service
public class JoueurService implements Serializable{

    private final JoueurRepository repository;

    private final EquipeRepository Erepository;

    public JoueurService(JoueurRepository repository, EquipeRepository erepository) {
        this.repository = repository;
        Erepository = erepository;
    }

    public Joueur findJoueur(Long id) {
        return this.repository.findById(id).orElse(new Joueur(null, null, null, null, null, null));
    }

    public Joueur addJoueur(Joueur model) {
        return this.repository.save(model);
    }

    @Deprecated
    public Joueur createRandomJoueur() {
        Faker faker = new Faker(new Locale("fr-FR"));
        Joueur joueur = new Joueur();
        joueur.setNom(faker.name().lastName());
        joueur.setPrenom(faker.name().firstName());
        joueur.setAge((int) ((Math.random() * (35 - 16)) + 16));
        joueur.setScore((int) ((Math.random() * 100)));
        return joueur;
    }

    public ArrayList<Joueur> createMultipleJoueur(Integer n) {
        ArrayList<Joueur> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Joueur newJoueur = addJoueur(createRandomJoueur());
            list.add(newJoueur);
        }
        return list;
    }

    public boolean addEquipeToJoueur(Long joueurId, Long equipe){
        Equipe tmpEquipe = this.Erepository.getReferenceById(equipe);
        Joueur joueur = this.repository.getReferenceById(joueurId);
        joueur.setId_equipe(tmpEquipe);
        this.repository.save(joueur);
        return true;
    }
}
