package com.matchs.api.Controller;

import com.matchs.api.Model.Equipe;
import com.matchs.api.Service.JoueurService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import com.matchs.api.Model.Joueur;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/joueur")
public class JoueurController {

    private final JoueurService service;

    public JoueurController(JoueurService service) {
        this.service = service;
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
    public ResponseEntity<Joueur> addJoueur(@RequestBody Joueur joueur){
        Joueur newJoueur = this.service.addJoueur(joueur);
        return new ResponseEntity<>(newJoueur, HttpStatus.OK);
    }
    @RequestMapping(value = "/addEtoJ/{idJ}/{idEq}", method = RequestMethod.PUT)
   public ResponseEntity<Joueur> updateEquipe(@PathVariable Long idJ, @PathVariable Equipe idEq) {
       boolean ans = this.service.addEquipeToJoueur(idJ, idEq);
       Joueur model = this.service.findJoueur(idJ);
       if (ans == true){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }else {
           return new ResponseEntity<>(model, HttpStatus.OK);
       }
    }
}
