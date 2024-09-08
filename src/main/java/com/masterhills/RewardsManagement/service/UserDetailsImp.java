package com.masterhills.RewardsManagement.service;

import com.masterhills.RewardsManagement.model.WrapperCredential;
import com.masterhills.RewardsManagement.repository.CredentialRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImp implements UserDetailsService {

    private final CredentialRepository credentialRepository;

    public UserDetailsImp(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var u = credentialRepository.findByEmail(email);
        return u.map(WrapperCredential::new)
                .orElseThrow(()-> new UsernameNotFoundException("Customer does not exist"));
    }
}
