package com.upstac.TestLab.service;

import com.upstac.TestLab.entity.UserDO;
import com.upstac.TestLab.model.User;
import com.upstac.TestLab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpstacUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        Optional<UserDO> userDO = userRepository.findByEmailId(emailId);
        if (userDO.isPresent()) {
            return new User(userDO.get());
        }else{
            throw new UsernameNotFoundException("User details not found");
        }
    }
}
