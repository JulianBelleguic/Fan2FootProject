package com.paris.api.controllers;

import com.paris.api.models.AssoParisParieurModel;
import com.paris.api.models.ParieModel;
import com.paris.api.models.ParieurModel;
import com.paris.api.services.AssoPariParieurService;
import com.paris.api.services.ParieurService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Parieur")

public class ParieurController {

    private final ParieurService service;
    private AssoPariParieurService serviceAsso;
    private ParieController parieController;

@Autowired
    public ParieurController(ParieurService service, @Lazy AssoPariParieurService serviceAsso, ParieController parieController){
        this.service = service;
        this.serviceAsso = serviceAsso;
        this.parieController = parieController;

    }
    @PostMapping("/create")
    @Operation(summary = "Create one 'parieur'.", description = "Create one 'parieur' from the provided Body.")
    public ParieurModel createParieur(@RequestBody ParieurModel parieur){
        return service.createParieur(parieur);
    }
    @PutMapping("/deleteByID/{id}")
    @Operation(summary = "Delete one 'parieur'.", description = "Delete one 'parieur' from the provided Id.")
    public String deleteByID(@RequestParam Long id){
        return service.deleteByID(id);
    }

    @PutMapping("/findByID/{id}")
    @Operation(summary = "Find one 'parieur'.", description = "Find one 'parieur' from the provided Id.")
    public ParieurModel searchById(@RequestParam Long id){
        ParieurModel model = this.service.findParieur(id);
        return model;
    }
    @GetMapping("/getParis")
    public List<ParieModel> getParis(){
        List<ParieModel> paris = parieController.findAll();
        return paris;
    }

    @GetMapping("/ajouterArgent")
    public ParieurModel ajouterArgent(@RequestParam Long id, @RequestParam double montant){
         return service.saveBalance(id, montant);
    }

    @GetMapping("/soustraireBalance")
    public ParieurModel soustraireBalance(@RequestParam Long id, @RequestParam double montant){
        return service.soustraireBalance(id, montant);
    }

    @GetMapping("/additionnerBalance")
    public ParieurModel additionnerBalance(@RequestParam Long id, @RequestParam double montant){
        return service.additionnerBalance(id, montant);
    }

    @GetMapping("/getParier")
    public List<AssoParisParieurModel> getParierByParieurId(@RequestParam Long id_parieur){
        List<AssoParisParieurModel> parier = serviceAsso.getParierByIdJoueur(id_parieur);

        return parier;
    }


}