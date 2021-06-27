package com.upstac.TestLab.service;

import com.upstac.TestLab.entity.UserDO;
import com.upstac.TestLab.exception.UserAlreadyExistsException;
import com.upstac.TestLab.exception.UserDetailsNotFound;
import com.upstac.TestLab.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDO acceptUserDetails(UserDO user) throws UserAlreadyExistsException {
        logger.debug("Entered acceptUserDetails", user);
        if(userRepository.findByEmailId(user.getEmailId()).isEmpty()){
            return userRepository.save(user);
        }else{
            throw new UserAlreadyExistsException("This emailId already exists please choose another : " + user.getEmailId());
        }
    }

    @Override
    public UserDO getUserDetails(int id) throws UserDetailsNotFound {
        logger.debug("Entered getUserDetails", id);
        Optional<UserDO> savedUser = userRepository.findById(id);
        if(savedUser.isPresent()){
            return savedUser.get();
        }else{
            throw new UserDetailsNotFound("User Details Not Found for the given id : " + id);
        }

    }

    @Override
    public UserDO getUserDetailsByEmailId(String emailId) throws UserDetailsNotFound {
        logger.debug("Entered getUserDetailsByEmailId", emailId);
        Optional<UserDO> savedUser = userRepository.findByEmailId(emailId);
        if(savedUser.isPresent()){
            return savedUser.get();
        }else{
            throw new UserDetailsNotFound("User Details Not Found for the given email : " + emailId);
        }
    }

    @Override
    public UserDO updateUserDetails(int initialUserId, UserDO user) throws UserDetailsNotFound {
        UserDO initialUser = getUserDetails(initialUserId);
        logger.info("Initial User details : " + initialUser.toString());
        initialUser.setName(user.getName());
        initialUser.setEmailId(user.getEmailId());
        initialUser.setAddress(user.getAddress());
        initialUser.setGender(user.getGender());
        initialUser.setPassword(user.getPassword());
        initialUser.setPhoneNumber(user.getPhoneNumber());
        initialUser.setRoles(user.getRoles());
        initialUser.setActive(user.isActive());
        userRepository.save(initialUser);
        return initialUser;
    }

    @Override
    public void addInitialUsers(){
        UserDO userDO1 = new UserDO("Sandeep","Male","Road A, City B, State C","1234567890", "abc1@email.com", "password", true, "ADMIN,CUSTOMER");
        userRepository.save(userDO1);
        UserDO userDO2 = new UserDO("Kumar","Male","Road A, City B, State C","1234567890", "abc2@email.com", "password", true, "ADMIN,CUSTOMER");
        userRepository.save(userDO2);
    }
}
