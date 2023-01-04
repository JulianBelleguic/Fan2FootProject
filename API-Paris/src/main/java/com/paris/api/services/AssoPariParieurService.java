package com.paris.api.services;

import com.paris.api.models.AssoParisParieurModel;
import com.paris.api.models.ParieModel;
import com.paris.api.models.ParieurModel;
import com.paris.api.repository.AssoPariParieurRepository;
import com.paris.api.repository.ParieurRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class AssoPariParieurService implements Serializable {

    private final AssoPariParieurRepository repository;
    private ParieService parieService;
    private ParieurService parieurService;


    public AssoPariParieurService (AssoPariParieurRepository repository,ParieService parieService, ParieurService parieurService){
        this.repository = repository;
        this.parieService = parieService;
        this.parieurService = parieurService;
    }

    public AssoParisParieurModel findAssoParisParieur(Long id) {
        return this.repository.findById(id).orElse(new AssoParisParieurModel());
    }

    public AssoParisParieurModel addAssoParisParieur(AssoParisParieurModel model) {
        return this.repository.save(model);
    }

    public AssoParisParieurModel parier( Long id_parieur,  Long id_parie,  double montant, String cote){
        AssoParisParieurModel model = new AssoParisParieurModel();
        ParieModel pariModel = this.parieService.findPari(id_parie);
        ParieurModel parieurModel = this.parieurService.findParieur(id_parieur) ;
        model.setIdParieur(parieurModel.getId());
        model.setIdParis(pariModel.getId());
        model.setMontant(montant);
        model.setCoteChoisie(cote);
        return this.repository.save(model);
    }

}