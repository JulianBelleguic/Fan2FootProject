package com.matchs.api.Web;

import com.matchs.api.Model.AppUser;
import com.matchs.api.Repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
@AllArgsConstructor
public class UserControllerWeb {

    private AppUserRepository appUserRepository;

    @GetMapping (path = "/index")
    public String users(Model model){
        List<AppUser> users = appUserRepository.findAll();
        model.addAttribute("listUsers",users);
        return "Users";
    }




}
