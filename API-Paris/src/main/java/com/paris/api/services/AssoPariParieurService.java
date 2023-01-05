package com.paris.api.services;

import com.paris.api.controllers.ParieController;
import com.paris.api.controllers.ParieurController;
import com.paris.api.models.AssoParisParieurModel;
import com.paris.api.models.ParieModel;
import com.paris.api.models.ParieurModel;
import com.paris.api.repository.AssoPariParieurRepository;
import com.paris.api.repository.ParieurRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class AssoPariParieurService implements Serializable {

    private final AssoPariParieurRepository repository;
    private ParieService parieService;
    private ParieurService parieurService;
    private ParieurController parieurController;


    public AssoPariParieurService (AssoPariParieurRepository repository,ParieService parieService, ParieurService parieurService, @Lazy ParieurController parieurController){
        this.repository = repository;
        this.parieService = parieService;
        this.parieurService = parieurService;
        this.parieurController = parieurController;
    }

    public AssoParisParieurModel findAssoParisParieur(Long id) {
        return this.repository.findById(id).orElse(new AssoParisParieurModel());
    }

    public AssoParisParieurModel addAssoParisParieur(AssoParisParieurModel model) {
        return this.repository.save(model);
    }
    public List<AssoParisParieurModel> getParierByIdJoueur(Long id_joueur){
        List<AssoParisParieurModel> parier = this.repository.findAllByIdParieur(id_joueur);
        return parier;
    }

    public AssoParisParieurModel parier( Long id_parieur,  Long id_parie,  double montant, String cote){
        ParieurModel parieur = parieurController.searchById(id_parieur);
        if (parieur.getBalance() < montant ||parieur.getBalance() > 0)
        {} else
        {
            double gainPotentiel;

            AssoParisParieurModel model = new AssoParisParieurModel();
            ParieModel pariModel = this.parieService.findByID(id_parie);
            ParieurModel parieurModel = this.parieurService.findParieur(id_parieur);
            if ("A".equalsIgnoreCase(cote) || "a".equalsIgnoreCase(cote))
            {
                gainPotentiel = montant * pariModel.getCoteA();
            } else if ("B".equalsIgnoreCase(cote) || "b".equalsIgnoreCase(cote)) {
                gainPotentiel = montant * pariModel.getCoteB();
            }
            else if ("N".equalsIgnoreCase(cote) || "n".equalsIgnoreCase(cote)) {
                gainPotentiel = montant * pariModel.getCoteN();
            } else
            {
                gainPotentiel = 0.0;
            }
            model.setIdParieur(parieurModel.getId());
            model.setIdParis(pariModel.getId());
            model.setMontant(montant);
            model.setCoteChoisie(cote);
            model.setGainPotentiel(gainPotentiel);
            return this.repository.save(model);
        }
        return new AssoParisParieurModel();
    }

}