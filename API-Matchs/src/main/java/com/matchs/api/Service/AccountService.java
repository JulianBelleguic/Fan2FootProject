package com.matchs.api.Service;

import com.github.javafaker.App;
import com.matchs.api.Model.AppRole;
import com.matchs.api.Model.AppUser;

import java.util.List;


public interface AccountService {

    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username, String rolename);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();


}
