package com.masterhills.RewardsManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AuthDto {
    @Email
    @NotNull(message = "email is required")
    private String email;

    @NotNull(message = "Password is required")
    @Size(min=8, max=15, message="Password must be between 8 and 15 characters")
    private String password;

    public AuthDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
