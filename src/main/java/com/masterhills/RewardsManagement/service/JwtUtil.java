package com.masterhills.RewardsManagement.service;

import com.masterhills.RewardsManagement.model.Credentials;
import com.masterhills.RewardsManagement.repository.CredentialRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUtil {

    private final CredentialRepository credentialRepository;

    public JwtUtil(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    public Long getUserIdFromJwt() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String email;

        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername();
        } else {
            email = principal.toString();
        }
        Credentials user = credentialRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return user.getId();

    }

}
