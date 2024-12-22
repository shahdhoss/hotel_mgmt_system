package com.example.hotel.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserLoginDto {
    @NotEmpty(message = "Email should not be empty")
    @Email
    protected String emailAddress;

    @NotEmpty(message = "Password should not be empty")
    @Size(min= 6)
    protected String password;

    public @NotEmpty(message = "Password should not be empty") @Size(min = 6) String getPassword() {
        return password;
    }

    public @NotEmpty(message = "Email should not be empty") @Email String getEmailAddress() {
        return emailAddress;
    }

    public void setPassword(@NotEmpty(message = "Password should not be empty") @Size(min = 6) String password) {
        this.password = password;
    }

    public void setEmailAddress(@NotEmpty(message = "Email should not be empty") @Email String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
