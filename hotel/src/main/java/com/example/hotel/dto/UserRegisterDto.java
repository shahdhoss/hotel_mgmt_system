package com.example.hotel.dto;

import jakarta.validation.constraints.*;

public class UserRegisterDto {
    protected Long id;
    @NotEmpty
    protected String firstName;
    @NotEmpty
    protected String lastName;
    @NotEmpty(message = "Email should not be empty")
    @Email
    protected String emailAddress;
    @NotEmpty(message = "Password should not be empty")
    @Size(min= 6)
    protected String password;

    public @NotEmpty String getLastName() {
        return lastName;
    }

    public @NotEmpty String getFirstName() {
        return firstName;
    }

    public @NotEmpty(message = "Email should not be empty") @Email String getEmailAddress() {
        return emailAddress;
    }

    public @NotEmpty(message = "Password should not be empty") String getPassword() {
        return password;
    }

    public void setFirstName(@NotEmpty String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(@NotEmpty String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(@NotEmpty(message = "Email should not be empty") @Email String email) {
        this.emailAddress = email;
    }

    public void setPassword(@NotEmpty(message = "Password should not be empty") String password) {
        this.password = password;
    }
}
