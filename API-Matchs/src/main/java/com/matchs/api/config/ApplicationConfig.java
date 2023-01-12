package com.matchs.api.config;


import com.matchs.api.Repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final AppUserRepository appUserRepository;

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> {
            return appUserRepository.findByUsername(username);
                    //.orElseThrow(()-> new UsernameNotFoundException("User not found")) ;
        };
    }

}
