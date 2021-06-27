package com.upstac.TestLab.model;

import lombok.Data;

@Data
public class LoginResponse {
    private final String jwtToken;

    public LoginResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }
}
