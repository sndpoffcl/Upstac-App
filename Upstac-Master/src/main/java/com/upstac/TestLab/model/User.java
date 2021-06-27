package com.upstac.TestLab.model;

import com.upstac.TestLab.entity.UserDO;
import lombok.Data;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class User implements UserDetails {

    private int id;
    private String name;
    private String gender;
    private String address;
    private String phoneNumber;
    private String emailId;
    private String password;
    private boolean active;
    private String roles;
    private String jwtToken;
    private List<GrantedAuthority> authorities;
    private List<Booking> bookings;

    public User(int id, String name, String gender, String address, String phoneNumber, String emailId, String password, boolean active) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.password = password;
        this.active = active;
    }

    public User(int id, String name, String gender, String address, String phoneNumber, String emailId, String password, boolean active,  List<GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.password = password;
        this.active = active;
        this.authorities = authorities;
    }

    public User() {
    }

    public User(UserDO userDO) {
        this(userDO.getId(),userDO.getName(), userDO.getGender(), userDO.getAddress(), userDO.getPhoneNumber(), userDO.getEmailId(), userDO.getPassword(),
                userDO.isActive());
        if(userDO.getRoles() != null && userDO.getRoles().length()>0) {
            this.authorities = Arrays.stream(userDO.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return emailId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
