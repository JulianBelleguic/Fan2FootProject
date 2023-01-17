package com.paris.api.services;

import com.paris.api.models.ParieModel;
import com.paris.api.repository.ParieRepository;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Service
public class ParieService implements Serializable {

    private static ParieRepository repository;

    public ParieService (ParieRepository repository){
        ParieService.repository = repository;
    }

    public ParieModel findByID(Long id) {
        return repository.findById(id).orElse(new ParieModel(null, null, 0,0,0));
    }
    @GetMapping("/all")
    public static List<ParieModel> all() {
        return repository.findAll();
    }

    public ParieModel createParie(ParieModel model) {
        return repository.save(model);
    }

    public String deleteByID(Long id){
        repository.deleteById(id);
        return "Parieur supprimer";
    }

    public Boolean addParie(Long idMatch, Float scoreEqip1, Float scoreEqip2){
        ParieModel newParie = new ParieModel(null, null, 0,0,0);
        newParie.setIdMatch(idMatch);
        newParie.setCoteA(calculChances(scoreEqip1, scoreEqip2, "A"));
        newParie.setCoteB(calculChances(scoreEqip1, scoreEqip2, "B"));
        newParie.setCoteN(calculChances(scoreEqip1, scoreEqip2, "N"));
        repository.save(newParie);
        return true;
    }

    private static Float calculChances (Float score1, Float score2, String call) {
        float chanceA, chanceB;
        Float result = null;

        float delta = Math.abs(score1 - score2);

        float chanceNulle = (float) ((50 - (delta / 2.0)) / 100.0);

        if (score1 >= score2) {
            chanceA = (float) (((50 + (delta / 2.0)) / 100.0) * ((50 + (delta / 2)) / 100.0));
            chanceB = (float) (((50 + (delta / 2.0)) / 100) * ((50 - (delta / 2)) / 100.0));
        }
        else {
            chanceA = (float) (((50 + (delta / 2.0)) / 100.0) * ((50 - (delta / 2)) / 100.0));
            chanceB = (float) (((50 + (delta / 2.0)) / 100) * ((50 + (delta / 2)) / 100.0));
        }

        if (Objects.equals(call, "A")) {

            result = Precision.round(1 / chanceA, 2);
        }
        else if (Objects.equals(call, "B")) {
            result = Precision.round(1 / chanceB, 2);
        }
        else if (Objects.equals(call, "N")) {
            result = Precision.round(1 / chanceNulle, 2);
        }
        return result;
    }

}