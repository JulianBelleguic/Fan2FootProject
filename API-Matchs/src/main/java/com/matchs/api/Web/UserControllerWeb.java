package com.matchs.api.Web;

import com.github.javafaker.App;
import com.matchs.api.Model.AppRole;
import com.matchs.api.Model.AppUser;
import com.matchs.api.Repository.AppUserRepository;
import com.matchs.api.Service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserControllerWeb {

    private AccountService accountService;
    private AppUserRepository appUserRepository;

    @GetMapping (path = "/index")
    public String users(Model model){
        List<AppUser> users = appUserRepository.findAll();
        model.addAttribute("listUsers",users);
        return "Users";
    }

    @PostMapping(path = "/users")
    public AppUser saveUser (@RequestBody AppUser appUser){
        return accountService.addNewUser(appUser);
    }

    @PostMapping(path = "/roles")
    public AppRole saveRole(@RequestBody AppRole appRole){
        return accountService.addNewRole(appRole);
    }


}
