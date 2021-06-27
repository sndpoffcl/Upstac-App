package com.upstac.TestLab.controller;

import com.upstac.TestLab.entity.UserDO;
import com.upstac.TestLab.exception.APIException;
import com.upstac.TestLab.exception.UserAlreadyExistsException;
import com.upstac.TestLab.exception.UserDetailsNotFound;
import com.upstac.TestLab.model.LoginRequest;
import com.upstac.TestLab.model.LoginResponse;
import com.upstac.TestLab.model.User;
import com.upstac.TestLab.securty.JWTUtil;
import com.upstac.TestLab.service.UpstacUserDetailsService;
import com.upstac.TestLab.service.UserService;
import com.upstac.TestLab.utility.DTOEntityConverter;
import com.upstac.TestLab.utility.EntityDTOConverter;
import com.upstac.TestLab.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserValidator userValidator;

    @Autowired
    UserService userService;

    @Autowired
    DTOEntityConverter dtoEntityConverter;

    @Autowired
    EntityDTOConverter entityDTOConverter;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UpstacUserDetailsService upstacUserDetailsService;

    @Autowired
    JWTUtil jwtUtil;

    @GetMapping("/")
    public ResponseEntity home(){
        return ResponseEntity.ok("<h1> Welcome </h1>");
    }

    @GetMapping("/user")
    public ResponseEntity user(){
        return ResponseEntity.ok("<h1> Welcome UserDO </h1>");
    }

    @GetMapping("/admin")
    public ResponseEntity admin(){
        return ResponseEntity.ok("<h1> Welcome Admin </h1>");
    }

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody User user) throws APIException, UserAlreadyExistsException {
        logger.info("User Registration : start", user.toString());
        userValidator.validateUser(user);
        UserDO newUserDO = dtoEntityConverter.convertUserToUserDO(user);
        newUserDO = userService.acceptUserDetails(newUserDO);
        User savedNewUser =  entityDTOConverter.convertUserDOToUser(newUserDO);

        final UserDetails userDetails = upstacUserDetailsService.loadUserByUsername(savedNewUser.getEmailId());
        final String jwtToken = jwtUtil.generateToken(userDetails);
        savedNewUser.setJwtToken(jwtToken);
        return ResponseEntity.ok(savedNewUser);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest request) throws APIException, UserDetailsNotFound {
        logger.info("Login : start", request.toString());
        userValidator.validateUserLogin(request);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmailId(), request.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new APIException("Invalid EmailId and Password");
        }
        final UserDetails userDetails = upstacUserDetailsService.loadUserByUsername(request.getEmailId());
        final String jwtToken = jwtUtil.generateToken(userDetails);

        LoginResponse loginResponse = new LoginResponse(jwtToken);
        return ResponseEntity.ok(loginResponse);
    }


}
