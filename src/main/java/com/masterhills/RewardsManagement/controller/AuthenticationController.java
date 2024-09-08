package com.masterhills.RewardsManagement.controller;

import com.masterhills.RewardsManagement.dto.AuthDto;
import com.masterhills.RewardsManagement.message.AuthenticationResponse;
import com.masterhills.RewardsManagement.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {


    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> register(
            @Valid @RequestBody AuthDto user
    ){
        AuthenticationResponse response = authService.signup(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @Valid @RequestBody AuthDto user
    ){
        AuthenticationResponse response = authService.authenticate(user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
