package com.paris.api.controllers;

import com.paris.api.models.AssoParisParieurModel;
import com.paris.api.models.ParieModel;
import com.paris.api.models.ParieurModel;
import com.paris.api.services.AssoPariParieurService;
import com.paris.api.services.ParieurService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
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
@RequestMapping("/parieur")
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
    @Operation(summary = "Add one 'parieur'.", description = "Add one 'parieur' from the provided Body.")
    public ParieurModel addParieur(@Valid @RequestBody ParieurModel parieur){
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
    public ResponseEntity<List<ParieurModel>> createMultipleParieur(@Max(20) @PathVariable ("n") Integer n) {
        ArrayList<ParieurModel> list = this.service.createMultipleParieur(n);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @GetMapping("/findByID")
    @Operation(summary = "Find one 'parieur'.", description = "Find one 'parieur' from the provided Id.")
    public ResponseEntity<ParieurModel> findByID(@RequestParam Long id){
        ParieurModel model = this.service.findParieur(id);
        if (model.getId() == null){
            return new ResponseEntity<>(model,HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(model,HttpStatus.FOUND);
        }
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