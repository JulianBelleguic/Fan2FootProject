package com.matchs.api;

import com.matchs.api.Model.AppRole;
import com.matchs.api.Model.AppUser;
import com.matchs.api.Model.Role;
import com.matchs.api.Service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class ApiMatchsApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiMatchsApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner start(AccountService accountService ){
		return args -> {
//			accountService.addNewRole(new AppRole(null, "USER"));
//			accountService.addNewRole(new AppRole(null, "ADMIN"));
//			accountService.addNewRole(new AppRole(null, "MANAGER"));
//			accountService.addNewUser(new AppUser(null, "admin","1234", new ArrayList<>(), null));
//			accountService.addNewUser(new AppUser(null, "user1","1234", new ArrayList<>(),null));
//			accountService.addNewUser(new AppUser(null, "user2","1234", new ArrayList<>(),null));
//			accountService.addNewUser(new AppUser(null, "manager","1234", new ArrayList<>(),null));
//
//			accountService.addRoleToUser("admin", "USER");
//			accountService.addRoleToUser("admin", "ADMIN");
//			accountService.addRoleToUser("admin", "MANAGER");
//			accountService.addRoleToUser("user1","USER");
//			accountService.addRoleToUser("user2","USER");
//			accountService.addRoleToUser("manager","USER");
//			accountService.addRoleToUser("manager","MANAGER");


		};

	}

}
