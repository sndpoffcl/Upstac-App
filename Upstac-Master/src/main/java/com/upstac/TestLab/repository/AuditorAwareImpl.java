package com.upstac.TestLab.repository;

import com.upstac.TestLab.securty.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Autowired
    JWTUtil jwtUtil;

    @Override
    public Optional<String> getCurrentAuditor() {

        String username = "app";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return Optional.of(username);
    }

}
