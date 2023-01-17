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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/Parieur")
@Validated
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
    @PutMapping("/add")
    @Operation(summary = "Ajoute one 'parieur'.", description = "Ajoute one 'parieur' from the provided Body.")
    public ParieurModel addParieur(@RequestBody ParieurModel parieur){
        return service.addParieur(parieur);
    }

    @PutMapping("/create")
    @Operation(summary = "Create and add user.", description = "Create and Add user with faker")
    public ResponseEntity<ParieurModel> createRandomParieur(){
        ParieurModel newParieur = this.service.addParieur(this.service.createRandomParieur());
        return new ResponseEntity<>(newParieur, HttpStatus.OK);
    }

    @PutMapping("/createmul/{n}")
    @Operation(summary = "Create n random gamblers.", description = "create n random gamblers with Faker")
    public ResponseEntity<List<ParieurModel>> createMultipleParieur(@PathVariable ("n") Integer n) {
        ArrayList<ParieurModel> list = this.service.createMultipleParieur(n);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }
    @GetMapping("/findByID/{id}")
    @Operation(summary = "Find one 'parieur'.", description = "Find one 'parieur' from the provided Id.")
    public ParieurModel searchById(@PathVariable Long id){
        return this.service.findParieur(id);
    }
    @DeleteMapping("/deleteByID/{id}")
    @Operation(summary = "Delete one 'parieur'.", description = "Delete one 'parieur' from the provided Id.")
    public String deleteByID(@PathVariable Long id){
        return service.delByID(id);
    }

    @PostMapping("/ajouterArgent")
    public ParieurModel ajouterArgent(@RequestParam Long id, @RequestParam double montant){
         return service.saveBalance(id, montant);
    }

    @PostMapping("/soustraireBalance")
    public ParieurModel soustraireBalance(@RequestParam Long id, @RequestParam double montant){
        return service.soustraireBalance(id, montant);
    }

    @PostMapping("/additionnerBalance")
    public ParieurModel additionnerBalance(@RequestParam Long id, @RequestParam double montant){
        return service.additionnerBalance(id, montant);
    }

    @PostMapping("/profit")
    public ResponseEntity updBalanceByMatch(@RequestParam Long idmatch,@RequestParam String cote ){
        this.service.updBalanceByMatch(idmatch, cote);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}