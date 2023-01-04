package com.paris.api.controllers;

import com.paris.api.models.AssoParisParieurModel;
import com.paris.api.models.ParieModel;
import com.paris.api.models.ParieurModel;
import com.paris.api.services.AssoPariParieurService;
import com.paris.api.services.ParieurService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Parieur")
public class ParieurController {

    private final ParieurService service;
    private final AssoPariParieurService serviceAsso;
    @Autowired
    public ParieurController(ParieurService service, AssoPariParieurService serviceAsso){
        this.service = service;
        this.serviceAsso = serviceAsso;
    }
    @PostMapping("/create")
    public ParieurModel createParieur(@RequestBody ParieurModel parieur){
        return service.createParieur(parieur);
    }
    @PutMapping("/deleteByID/{id}")
    public String deleteByID(@RequestParam Long id){
        return service.deleteByID(id);
    }

    @PutMapping("/findByID/{id}")
    public ParieurModel searchById(@RequestParam Long id){
        ParieurModel model = this.service.findParieur(id);
        return model;
    }
    @GetMapping("/getParis")
    public List<ParieModel> getParis(){
        List<ParieModel> paris = ParieController.findAll();
        return paris;
    }

    @GetMapping("/parier")
    public ResponseEntity<AssoParisParieurModel> parier(@RequestParam Long id_parieur,@RequestParam Long id_parie, @RequestParam double montant, @RequestParam String cote){
        AssoParisParieurModel parier = new AssoParisParieurModel(null, id_parieur, id_parie, montant, cote, 0);
        if (parier.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(parier, HttpStatus.OK);
        }
    }
}