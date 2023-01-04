package com.paris.api.services;

import com.paris.api.models.ParieModel;
import com.paris.api.models.info_match;
import com.paris.api.repository.ParieRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Service
public class ParieService implements Serializable {

    private static ParieRepository repository;
    private static List<ParieModel> all;

    public ParieService (ParieRepository repository){
        this.repository = repository;
    }

    public ParieModel findByID(Long id) {
        return this.repository.findById(id).orElse(new ParieModel());
    }
    @GetMapping("/all")
    public static List<ParieModel> all() {
        return all;
    }

    public ParieModel createParie(ParieModel model) {
        return this.repository.save(model);
    }

    public String deleteByID(Long id){
        repository.deleteById(id);
        return "Parieur supprimer";
    }

    public ParieModel addParie(Long id){
        //info_match result = new info_match(null,null,null,null,null);
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl  = "http://localhost:8080/api/match/scores";
        info_match response = restTemplate.getForObject(fooResourceUrl + "?id=" + id, info_match.class);
        System.out.println(response);
        ParieModel newParie = new ParieModel(null, null, 0,0,0);
        assert response != null;
        newParie.setIdMatch(response.getId_match());
        newParie.setCoteA(calculChances(response.getScore_eq1(), response.getScore_eq2(), "A"));
        newParie.setCoteB(calculChances(response.getScore_eq1(), response.getScore_eq2(), "B"));
        newParie.setCoteN(calculChances(response.getScore_eq1(), response.getScore_eq2(), "N"));
        return this.repository.save(newParie);
    }

    private static Float calculChances (Integer score1, Integer score2, String call) {
        float chanceA, chanceB;
        Float result = null;

        int delta = Math.abs(score1 - score2);


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

            result = 1 / chanceA;
        }
        else if (Objects.equals(call, "B")) {
            result = 1 / chanceB;
        }
        else if (Objects.equals(call, "N")) {
            result = 1 / chanceNulle;
        }
        return result;
    }

}