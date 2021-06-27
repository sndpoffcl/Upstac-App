package com.upstac.TestLab.model;

import lombok.Data;

@Data
public class ResetPasswordRequest {
    String username;
    String oldPassword;
    String newPassword;
}

