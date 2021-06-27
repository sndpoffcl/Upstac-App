package com.upstac.TestLab.validator;

import com.upstac.TestLab.exception.APIException;
import com.upstac.TestLab.model.LoginRequest;
import com.upstac.TestLab.model.ResetPasswordRequest;
import com.upstac.TestLab.model.User;

public interface UserValidator {
    public void validateUser(User user) throws APIException;
    public void validateUserLogin(LoginRequest login) throws APIException;
    public void validateResetPassword(ResetPasswordRequest resetPasswordRequest) throws APIException;
}
