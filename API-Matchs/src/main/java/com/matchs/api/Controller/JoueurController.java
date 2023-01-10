package com.matchs.api.Controller;

import com.matchs.api.Mapstruct.Mapper.MapStructMapper;
import com.matchs.api.Model.Equipe;
import com.matchs.api.Repository.JoueurRepository;
import com.matchs.api.Service.JoueurService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.matchs.api.Model.Joueur;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/joueur")

public class JoueurController {

    private MapStructMapper mapstructMapper;

    private JoueurRepository joueurRepository;

    @Autowired
    public JoueurController(
            MapStructMapper mapstructMapper,
            JoueurRepository joueurRepository
    ) {
        this.mapstructMapper = mapstructMapper;
        this.joueurRepository = joueurRepository;
    }

    /*
    private final JoueurService service;

    public JoueurController(JoueurService service) {
        this.service = service;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Joueur> getJoueurById(@PathVariable ("id") Long id) {
        Joueur model = this.service.findJoueur(id);
        if (model.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(model, HttpStatus.OK);
        }
    }

    //COUCOU TOI

    @PostMapping("/add")
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
    */

}
