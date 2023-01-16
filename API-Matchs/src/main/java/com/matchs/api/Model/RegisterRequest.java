package com.matchs.api.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {

    private String username;
    private String password;

}
