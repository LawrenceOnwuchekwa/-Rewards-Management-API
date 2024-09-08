package com.masterhills.RewardsManagement.repository;

import com.masterhills.RewardsManagement.model.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialRepository extends JpaRepository<Credentials,Long> {

    Optional<Credentials> findByEmail(String email);

    boolean existsByEmail(String email);
}
