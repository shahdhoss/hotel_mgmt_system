package com.example.hotel.repository;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "guest")
public class Guest extends User{

    @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
    List<Reservation> reservations = new ArrayList<>();
    public Guest(){}

    public Guest(String emailAddress, String firstName, String lastName, String password){
        setEmailAddress(emailAddress);
        setFirstName(firstName);
        setLastName(lastName);
        setPassword(password);
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }
    public Long getId(){
        return this.id;
    }
    public String getPassword() {
        return this.password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

}
