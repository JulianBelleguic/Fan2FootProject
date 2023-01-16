package com.matchs.api.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticationRequest {

    private String username;
    private String password;

}
