package com.matchs.api.Controller;

import com.matchs.api.Mapstruct.Mapper.MapStructMapper;
import com.matchs.api.Model.Equipe;
import com.matchs.api.Repository.EquipeRepository;
import com.matchs.api.Service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipe")
public class EquipeController {

    private MapStructMapper mapstructMapper;

    private EquipeRepository equipeRepository;

    @Autowired
    public EquipeController(
            MapStructMapper mapstructMapper,
            EquipeRepository equipeRepository
    ) {
        this.mapstructMapper = mapstructMapper;
        this.equipeRepository = equipeRepository;
    }



    /*
    // on créé l'attribut de class qui va contenir le service associé à notre controller
    private final EquipeService equipeService;

    public EquipeController(EquipeService service, EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Equipe>> getEquipes() {
        List<Equipe> equipes = this.equipeService.findAllEquipes();
        return new ResponseEntity<>(equipes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Equipe> getEquipeById(@PathVariable ("id") Long id) {
        Equipe model = this.equipeService.findEquipe(id);
        if (model.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(model, HttpStatus.OK);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Equipe> addEquipe(@RequestBody Equipe equipe) {
        Equipe newEquipe = equipeService.addEquipe(equipe);
        return new ResponseEntity<>(newEquipe, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Equipe> updateEquipe(@RequestBody Equipe equipe)  {
        Equipe updatedEquipe = equipeService.updEquipe(equipe);
        return new ResponseEntity<>(updatedEquipe, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Equipe> deleteEquipeById(@PathVariable ("id") Long id) {
        equipeService.delEquipe(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    */
}