package xyz.victorl.scrontchback.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

    private String accessToken;
    private String refreshToken;

}
