package com.matchs.api.Service;

import com.matchs.api.Model.AppRole;
import com.matchs.api.Model.AppUser;
import com.matchs.api.Repository.AppRoleRepository;
import com.matchs.api.Repository.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional

public class AccountServiceImpl implements AccountService {

    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AppUser addNewUser(AppUser appUser) {
        String pw = appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pw));
        return appUserRepository.save(appUser);
    }

    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    public void addRoleToUser(String username, String rolename) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRolename(rolename);
        appUser.getAppRoles().add(appRole);
    }

    public AppUser findUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    public List<AppUser> listUsers() {
        return  appUserRepository.findAll();
    }




}
