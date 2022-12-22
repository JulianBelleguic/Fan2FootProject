package com.paris.api.controllers;
import com.paris.api.models.AssoParisParieurModel;
import com.paris.api.services.AssoPariParieurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/AssoPariParieur")
public class AssoPariParieurController {

    private final AssoPariParieurService service;

    public AssoPariParieurController(AssoPariParieurService service){
        this.service = service;
    }

    @GetMapping("/searchByID")
    public ResponseEntity<AssoParisParieurModel> searchById(@RequestParam Long id){
        AssoParisParieurModel model = this.service.findAssoParisParieur(id);
        if (model.getId() == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity(model, HttpStatus.OK);
        }
    }
}