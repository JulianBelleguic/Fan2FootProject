package com.matchs.api.Web;

import com.matchs.api.Controller.EquipeController;
import com.matchs.api.Model.Equipe;
import com.matchs.api.Repository.EquipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class EquipeRestController {

    private EquipeController equipeController;
    private EquipeRepository equipeRepository;


    @GetMapping(path = "/equipe")
    public String DisplayEquipes(ModelMap model,
                                 @RequestParam(name = "page",defaultValue = "0") int page,
                                 @RequestParam(name = "size",defaultValue = "5")int size,
                                 @RequestParam(name = "rechercher",defaultValue = "")String rechercher){
        Page<Equipe> pageequipes=equipeRepository.findByNomContains(rechercher, PageRequest.of(page,size));
        model.addAttribute("listEquipes",pageequipes.getContent());
        model.addAttribute("pages", new int [pageequipes.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("rechercher", rechercher);
        return "equipe";
    }

    @RequestMapping("/GenEquipes")
    public String GenEquipes(String rechercher, int page) {
        equipeController.createRandomEquipe();
        return "redirect:/equipe?page="+page+"&rechercher="+rechercher;
    }

    @GetMapping("/deleteEquipe")
    public String deleteEquipe(Long id, String rechercher, int page) {
        equipeRepository.deleteById(id);
        return "redirect:/equipe?page="+page+"&rechercher="+rechercher;
        //return "redirect:/Acceuil";
    }
}
