package com.matchs.api.Web;

import com.matchs.api.Model.Resultat;
import com.matchs.api.Repository.ResultatRepository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ResultatRestController {

    ResultatRepository resultatRepository;


    @GetMapping("/deleteResultat")
    public String deleteResultat(Long id, String rechercher, int page) {
        resultatRepository.deleteById(id);
        return "redirect:/resultat?page="+page+"&rechercher="+rechercher;
        //return "redirect:/Acceuil";
    }
}
