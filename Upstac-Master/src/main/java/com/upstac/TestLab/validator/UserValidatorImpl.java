package com.upstac.TestLab.validator;

import com.upstac.TestLab.exception.APIException;
import com.upstac.TestLab.model.LoginRequest;
import com.upstac.TestLab.model.ResetPasswordRequest;
import com.upstac.TestLab.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements UserValidator{

    @Override
    public void validateUser(User user) throws APIException {
        if(user.getEmailId() == null || user.getEmailId().length() <= 0)
            throw new APIException("Invalid EmailId");
        if(user.getName() == null || user.getName().length() <= 0 )
            throw new APIException("Invalid Name");
        if(user.getGender() == null || user.getGender().length() <= 0 )
            throw new APIException("Invalid gender");
        if(user.getPassword() == null || user.getPassword().length() <= 0   )
            throw new APIException("Invalid password");
        if(user.getAddress() == null || user.getAddress().length() <= 0   )
            throw new APIException("Invalid Address");
        if(user.getPhoneNumber() == null || user.getPhoneNumber().length() <= 0   )
            throw new APIException("Invalid PhoneNumber");
    }

    @Override
    public void validateUserLogin(LoginRequest login) throws APIException {
        if(login.getEmailId() == null || login.getEmailId().length() <= 0)
            throw new APIException("Invalid EmailId");
        if(login.getPassword() == null || login.getPassword().length() <= 0 )
            throw new APIException("Invalid Password");
    }

    @Override
    public void validateResetPassword(ResetPasswordRequest resetPasswordRequest) throws APIException {

    }
}
