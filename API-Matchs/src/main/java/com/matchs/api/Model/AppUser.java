package com.matchs.api.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;


@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter
@Setter

public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> appRoles=new ArrayList<>();

}
