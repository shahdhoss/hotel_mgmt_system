package com.example.hotel.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "guest")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String emailAddress;
    @Column(nullable = false)
    private String password;

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
