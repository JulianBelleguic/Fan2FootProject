package com.paris.api.controllers;
import com.paris.api.models.ParierModel;
import com.paris.api.services.AssoPariParieurService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/parier")
@Validated

public class ParierController {

    private final AssoPariParieurService service;
    @Autowired
    public ParierController(AssoPariParieurService service){
        this.service = service;
    }

    @GetMapping("/searchByID")
    @Operation(summary = "Select one entity.", description = "Select one entity from AssoParisParieur association table.")
    public ResponseEntity<ParierModel> searchById(@RequestParam Long id){
        ParierModel model = this.service.findPari(id);
        if (model.getId() == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity(model, HttpStatus.OK);
        }
    }

    @PutMapping("/add")
    public ResponseEntity<ParierModel> parier(@RequestParam Long id_parieur, @RequestParam Long id_parie, @RequestParam double montant, @RequestParam String cote){
        ParierModel parier = this.service.parier(id_parieur, id_parie, montant, cote);

        if (parier.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(parier, HttpStatus.OK);
        }
    }



}