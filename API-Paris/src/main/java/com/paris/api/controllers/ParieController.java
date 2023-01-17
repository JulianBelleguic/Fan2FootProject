package com.paris.api.controllers;

import com.paris.api.models.ParieModel;
import com.paris.api.services.ParieService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pari")
@Validated
public class ParieController {

    private final ParieService service;

    @Autowired
    public ParieController(ParieService service){
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParieModel>> findAll() {
        List<ParieModel> paris = ParieService.all();
        if (paris.isEmpty()) {
            return new ResponseEntity<>(paris, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(paris, HttpStatus.FOUND);
        }
    }

    @GetMapping("/findById")
    @Operation(summary = "Find one 'pari'.", description = "Find one 'pari' from the provided Id.")
    public ResponseEntity<ParieModel> findByID(@RequestParam Long id){
        ParieModel model = this.service.findByID(id);
        if (model.getId() == null){
            return new ResponseEntity<>(model,HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(model,HttpStatus.FOUND);
        }
    }

    @PutMapping("/add")
    @Operation(summary = "Create one 'pari'.", description = "Create one 'pari' from idmatch and score team's.")
    public ResponseEntity<ParieModel> addParie(@RequestParam Long idMatch, @RequestParam Float scoreEqip1, @RequestParam Float scoreEqip2){
        ParieModel model = this.service.addParie(idMatch, scoreEqip1, scoreEqip2);
        if (model.getId()==null){
            return new ResponseEntity<>(model,HttpStatus.NOT_ACCEPTABLE);
        }else{
            return new ResponseEntity<>(model,HttpStatus.CREATED);
        }
    }

    @PutMapping("/addByJSON")
    @Operation(summary = "Create one 'pari'.", description = "Create one 'pari' from the provided JSON Body.")
    public ResponseEntity<ParieModel> addByJSON(@Valid @RequestBody ParieModel pari){
        ParieModel model = this.service.createPari(pari);
        if (model.getId()==null){
            return new ResponseEntity<>(model,HttpStatus.NOT_ACCEPTABLE);
        }else{
            return new ResponseEntity<>(model,HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/deleteByID/{id}")
    @Operation(summary = "Delete one 'pari'.", description = "Delete one 'pari' from the provided Id.")
    public ResponseEntity<String> delByID(@PathVariable Long id){
        boolean result = service.delByID(id);
        if (result){
            return new ResponseEntity<>("Pari effacé.",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Pari non trouvé",HttpStatus.NO_CONTENT);
        }

    }

}