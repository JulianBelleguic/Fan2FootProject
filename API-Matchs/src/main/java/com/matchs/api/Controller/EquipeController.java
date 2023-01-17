package com.matchs.api.Controller;

import com.matchs.api.Model.Equipe;
import com.matchs.api.Repository.EquipeRepository;
import com.matchs.api.Service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/equipe")


public class EquipeController {
    // on crée l'attribut de class qui va contenir le service associé à notre controller
    private final EquipeService equipeService;
    private final EquipeRepository repository;

    @Autowired
    public EquipeController(EquipeService equipeService, EquipeRepository repository) {
        this.equipeService = equipeService;
        this.repository = repository;
    }

    @GetMapping("/all")
    @Operation(summary = "Get all teams.", description = "Get all teams for DB.")
    public ResponseEntity<List<Equipe>> getEquipes() {
        List<Equipe> equipes = this.equipeService.findAllEquipes();
        return new ResponseEntity<>(equipes, HttpStatus.OK);
    }

    @PutMapping("/create")
    @Operation(summary = "Create random team.", description = "create a random team with Faker")
    public ResponseEntity<Equipe> createRandomEquipe() {
        Equipe newEquipe = this.equipeService.addEquipe(this.equipeService.createRandomEquipe());
        return new ResponseEntity<>(newEquipe, HttpStatus.CREATED);
    }

    @PutMapping("/createmul/{n}")
    @Operation(summary = "Create n random full teams.", description = "create n random teams with Faker")
    public ResponseEntity<List<Equipe>> createMultipleEquipe(@PathVariable ("n") Integer n) {
        ArrayList<Equipe> list = this.equipeService.createMultipleEquipe(n);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @PutMapping("/createfull")
    @Operation(summary = "Create random full team.", description = "create a random full team with Faker")
    public ResponseEntity<Equipe> createRandomFullEquipe() {
        Equipe newEquipe = this.equipeService.createRandomFUllEquipe();
        return new ResponseEntity<>(newEquipe, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    @Operation(summary = "Select one team.", description = "Get one team from the provided Id.")
    public ResponseEntity<Equipe> getEquipeById(@PathVariable ("id") Long id) {
        Equipe model = this.equipeService.findEquipe(id);
        if (model.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(model, HttpStatus.OK);
        }
    }

    @PutMapping("/add")
    @Operation(summary = "Add team.", description = "Add team from the provided Body.")
    public ResponseEntity<Equipe> addEquipe(@RequestBody Equipe equipe) {
        Equipe newEquipe = equipeService.addEquipe(equipe);
        return new ResponseEntity<>(newEquipe, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    @Operation(summary = "Update team.", description = "Update team from the provided Body.")
    public ResponseEntity<Equipe> updateEquipe(@RequestBody Equipe equipe)  {
        if (!repository.existsById(equipe.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        else {
            equipeService.updEquipe(equipe);
            return new ResponseEntity<>(equipe,HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete team.", description = "Delete team of provided Id.")
    public ResponseEntity<Equipe> deleteEquipeById(@PathVariable ("id") Long id) {
        if (!repository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        else {
            equipeService.delEquipe(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}