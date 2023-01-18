package com.matchs.api.Web;

import com.matchs.api.Model.Joueur;
import com.matchs.api.Model.Match;
import com.matchs.api.Model.Resultat;
import com.matchs.api.Repository.MatchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class MatchRestController {

    MatchRepository matchRepository;

    @GetMapping("/deleteMatch")
    public String deleteMatch(Long id, String rechercher, int page) {
        matchRepository.deleteById(id);
        return "redirect:/match?page="+page+"&rechercher="+rechercher;
        //return "redirect:/Acceuil";
    }
}
