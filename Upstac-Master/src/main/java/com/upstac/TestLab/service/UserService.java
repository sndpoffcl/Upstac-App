package com.upstac.TestLab.service;

import com.upstac.TestLab.entity.UserDO;
import com.upstac.TestLab.exception.UserDetailsNotFound;
import com.upstac.TestLab.exception.UserAlreadyExistsException;

public interface UserService {
    public UserDO acceptUserDetails(UserDO user) throws UserAlreadyExistsException;
    public UserDO getUserDetails(int id) throws UserDetailsNotFound;
    public UserDO getUserDetailsByEmailId(String emailId) throws UserDetailsNotFound;
    public UserDO updateUserDetails(int initialUserId, UserDO user) throws UserDetailsNotFound;
    public void addInitialUsers();
}
