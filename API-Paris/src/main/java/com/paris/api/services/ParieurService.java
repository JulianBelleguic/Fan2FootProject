package com.paris.api.services;

import com.paris.api.models.AssoParisParieurModel;
import com.paris.api.models.ParieModel;
import com.paris.api.models.ParieurModel;
import com.paris.api.repository.AssoPariParieurRepository;
import com.paris.api.repository.ParieurRepository;
import org.springframework.stereotype.Service;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ParieurService implements Serializable {

    private final ParieurRepository repository;
    private final AssoPariParieurRepository assoRepository;

    public ParieurService (ParieurRepository repository, AssoPariParieurRepository assoRepository){
        this.repository = repository;
        this.assoRepository = assoRepository;
    }


    public ParieurModel findParieur(Long id) {
        return this.repository.findById(id).orElse(new ParieurModel());
    }

    @Deprecated
    public ParieurModel createRandomParieur() {
        Faker faker = new Faker(new Locale("fr-FR"));
        ParieurModel parieur = new ParieurModel();
        parieur.setNom(faker.name().lastName());
        parieur.setPrenom(faker.name().firstName());
        parieur.setBalance((int) ((Math.random() * 5000)));
        return parieur;
    }

    public ArrayList<ParieurModel> createMultipleParieur(Integer n) {
        ArrayList<ParieurModel> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ParieurModel newParieur = addParieur(createRandomParieur());
            list.add(newParieur);
        }
        return list;
    }

    public ParieurModel addParieur(ParieurModel model) {
        return this.repository.save(model);
    }

    public String deleteByID(Long id){
        repository.deleteById(id);
        return "Parieur supprimer";
    }

    public void updBalanceByMatch(Long idmatch, String cote){
        List<AssoParisParieurModel> lst = this.assoRepository.findUpdParieur(idmatch, cote);
        for (AssoParisParieurModel obj :lst){
            ParieurModel parieur = findParieur(obj.getIdParieur());
            parieur.setBalance(parieur.getBalance()+ obj.getGainPotentiel());
            this.repository.save(parieur);
        }
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

}