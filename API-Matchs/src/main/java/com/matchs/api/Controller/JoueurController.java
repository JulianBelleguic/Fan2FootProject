package com.matchs.api.Controller;

import com.matchs.api.Model.Equipe;
import com.matchs.api.Repository.JoueurRepository;
import com.matchs.api.Service.JoueurService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.matchs.api.Model.Joueur;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/joueur")
public class JoueurController {

    private final JoueurService service;
    private final JoueurRepository repository;

    public JoueurController(JoueurService service, JoueurRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping("/create")
    @Operation(summary = "Create and add player.", description = "Create and Add player with faker ")
    public ResponseEntity<Joueur> createRandomJoueur(){
        Joueur newJoueur = this.service.addJoueur(this.service.createRandomJoueur());
        return new ResponseEntity<>(newJoueur, HttpStatus.OK);
    }

    @PostMapping("/createmul/{n}")
    @Operation(summary = "Create n random players.", description = "create n random players with Faker")
    public ResponseEntity<List<Joueur>> createMultipleJoueur(@PathVariable ("n") Integer n) {
        ArrayList<Joueur> list = this.service.createMultipleJoueur(n);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    @Operation(summary = "Select one player.", description = "Get one player from the Id provided.")
    public ResponseEntity<Joueur> getJoueurById(@PathVariable ("id") Long id) {
        Joueur model = this.service.findJoueur(id);
        if (model.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(model, HttpStatus.OK);
        }
    }

    @PostMapping("/add")
    @Operation(summary = "Add player.", description = "Add player from the Body provided.")
    public ResponseEntity<Joueur> addJoueur(@Valid @RequestBody Joueur joueur){
        Joueur newJoueur = this.service.addJoueur(joueur);
        return new ResponseEntity<>(newJoueur, HttpStatus.OK);
    }
    @RequestMapping(value = "/addEtoJ/{idJ}/{idEq}", method = RequestMethod.PUT)
   public ResponseEntity<Joueur> updateEquipeDuJoueur(@PathVariable Long idJ, @PathVariable Equipe idEq) {
       boolean ans = this.service.addEquipeToJoueur(idJ, idEq);
       Joueur model = this.service.findJoueur(idJ);
       if (ans){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }else {
           return new ResponseEntity<>(model, HttpStatus.OK);
       }
    }

    @PutMapping("/update")
    @Operation(summary = "Update player.", description = "Update player from the Id provided to the body provided.")
    public ResponseEntity<Joueur> updateJoueur(@Valid @RequestBody Joueur updatedJoueur){
        if (repository.existsById(updatedJoueur.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        else {
            service.updateJoueur(updatedJoueur);
            return new ResponseEntity<>(updatedJoueur,HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete player.", description = "Delete player from the Id provided.")
    public ResponseEntity<Joueur> deleteJoueurById(@PathVariable Long id){
        Joueur model = this.service.findJoueur(id);
        if (model.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        else {
            service.deleteJoueur(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
