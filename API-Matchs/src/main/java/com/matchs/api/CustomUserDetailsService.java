package com.matchs.api;

import com.matchs.api.Model.AppUser;
import com.matchs.api.Service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private AccountService accountService;

    public CustomUserDetailsService(AccountService accountService, PasswordEncoder passwordEncoder) {
        this.accountService = accountService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = accountService.findUserByUsername(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        appUser.getAppRoles().forEach(r -> {
            authorities.add(new SimpleGrantedAuthority(r.getRolename()));
        });
        return new User(appUser.getUsername(), appUser.getPassword(), authorities);
    }
}
