package com.matchs.api.Controller;

import com.matchs.api.Model.Equipe;
import com.matchs.api.Service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipe")
public class EquipeController {
    // on crée l'attribut de class qui va contenir le service associé à notre controller
    private final EquipeService equipeService;

    @Autowired
    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    @GetMapping("/all")
    @Operation(summary = "Get all teams.", description = "Get all teams for DB.")
    public ResponseEntity<List<Equipe>> getEquipes() {
        List<Equipe> equipes = this.equipeService.findAllEquipes();
        return new ResponseEntity<>(equipes, HttpStatus.OK);
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

    @PostMapping("/add")
    @Operation(summary = "Add team.", description = "Add team from the provided Body.")
    public ResponseEntity<Equipe> addEquipe(@RequestBody Equipe equipe) {
        Equipe newEquipe = equipeService.addEquipe(equipe);
        return new ResponseEntity<>(newEquipe, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @Operation(summary = "Update team.", description = "Update team from the provided Body.")
    public ResponseEntity<Equipe> updateEquipe(@RequestBody Equipe equipe)  {
        Equipe updatedEquipe = equipeService.updEquipe(equipe);
        return new ResponseEntity<>(updatedEquipe, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete team.", description = "Delete team from the provided Id.")
    public ResponseEntity<Equipe> deleteEquipeById(@PathVariable ("id") Long id) {
        equipeService.delEquipe(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}