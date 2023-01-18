package com.paris.api.services;

import com.paris.api.models.ParierModel;
import com.paris.api.models.ParieModel;
import com.paris.api.models.ParieurModel;
import com.paris.api.repository.AssoPariParieurRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class AssoPariParieurService implements Serializable {

    private final AssoPariParieurRepository repository;
    private final ParieService parieService;
    private final ParieurService parieurService;


    public AssoPariParieurService (AssoPariParieurRepository repository,ParieService parieService, ParieurService parieurService){
        this.repository = repository;
        this.parieService = parieService;
        this.parieurService = parieurService;
    }

    public ParierModel findPari(Long id) {
        return this.repository.findById(id).orElse(new ParierModel());
    }

    public ParierModel addAssoParisParieur(ParierModel model) {
        return this.repository.save(model);
    }
    public List<ParierModel> getParierByIdJoueur(Long id_joueur){
        return this.repository.findAllByIdParieur(id_joueur);
    }

    public ParierModel parier(Long id_parieur, Long id_parie, double montant, String cote){
        ParieurModel parieurModel = this.parieurService.findParieur(id_parieur);
        ParieModel pariModel = this.parieService.findByID(id_parie);
        if (pariModel.getId() != null && parieurModel.getId() != null && parieurModel.getBalance() > montant) {
                double gainPotentiel;
                ParierModel model = new ParierModel();
                if ("A".equalsIgnoreCase(cote) || "a".equalsIgnoreCase(cote)) {
                    gainPotentiel = montant * pariModel.getCoteA();
                } else if ("B".equalsIgnoreCase(cote) || "b".equalsIgnoreCase(cote)) {
                    gainPotentiel = montant * pariModel.getCoteB();
                } else if ("N".equalsIgnoreCase(cote) || "n".equalsIgnoreCase(cote)) {
                    gainPotentiel = montant * pariModel.getCoteN();
                } else {
                    gainPotentiel = 0.0;
                }
                model.setIdParieur(parieurModel.getId());
                model.setIdParis(pariModel.getId());
                model.setMontant(montant);
                model.setCoteChoisie(cote);
                model.setGainPotentiel(gainPotentiel);
                return this.repository.save(model);
        }
        else {
            return new ParierModel();
        }
    }

}