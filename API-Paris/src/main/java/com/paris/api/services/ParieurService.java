package com.paris.api.services;

import com.paris.api.models.ParieModel;
import com.paris.api.models.ParieurModel;
import com.paris.api.repository.ParieurRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;
import java.util.List;

@Service
public class ParieurService implements Serializable {

    private final ParieurRepository repository;

    public ParieurService (ParieurRepository repository){
        this.repository = repository;
    }

    public ParieurModel findParieur(Long id) {
        return this.repository.findById(id).orElse(new ParieurModel());
    }

    public ParieurModel createParieur(ParieurModel model) {
        return this.repository.save(model);
    }

    public String deleteByID(Long id){
        repository.deleteById(id);
        return "Parieur supprimer";
    }
    @GetMapping("/parieur/paris")
    public List<ParieModel> getParie(){
        List<ParieModel> paris = ParieService.all();
        return paris;
    }

}