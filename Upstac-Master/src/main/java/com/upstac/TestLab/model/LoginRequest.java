package com.upstac.TestLab.model;

import lombok.Data;

@Data
public class LoginRequest {
    private String emailId;
    private String password;
}
