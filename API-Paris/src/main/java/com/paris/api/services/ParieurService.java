package com.paris.api.services;

import com.github.javafaker.Faker;
import com.paris.api.models.AssoParisParieurModel;
import com.paris.api.models.ParieModel;
import com.paris.api.models.ParieurModel;
import com.paris.api.repository.ParieRepository;
import com.paris.api.repository.ParieurRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ParieurService implements Serializable {

    private final ParieurRepository repository;

    public ParieurService (ParieurRepository repository){
        this.repository = repository;
    }


    public ParieurModel findParieur(Long id) {
        return this.repository.findById(id).orElse(new ParieurModel());
    }

    public ParieurModel createRandomParieur() {
        Faker faker = new Faker(new Locale("fr-FR"));
        ParieurModel parieur = new ParieurModel();
        parieur.setNom(faker.name().lastName());
        parieur.setPrenom(faker.name().firstName());
        parieur.setBalance((int) ((Math.random() * 5000)));
        return parieur;
    }

    public ParieurModel addParieur(ParieurModel model) {
        return this.repository.save(model);
    }
    public ParieurModel saveBalance(Long id, double montant) {
        ParieurModel parieur = this.findParieur(id);
        parieur.setBalance(montant);
        return this.repository.save(parieur);
    }
    public ParieurModel soustraireBalance(Long id, double montant) {
        ParieurModel parieur = this.findParieur(id);
        parieur.setBalance(parieur.getBalance() - montant);
        return this.repository.save(parieur);
    }
    public ParieurModel additionnerBalance(Long id, double montant) {
        ParieurModel parieur = this.findParieur(id);
        parieur.setBalance(parieur.getBalance() + montant);
        return this.repository.save(parieur);
    }

    public String deleteByID(Long id){
        repository.deleteById(id);
        return "Parieur supprimer";
    }



}