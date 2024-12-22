package com.example.hotel.repository;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="staff")
public class Staff extends User{

    @Column(nullable = false)
    private Long NationalId;
    @Column(nullable = false)
    private String jobTitle;
    private LocalDate startDay;
    private LocalDate lastWorkingDay;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    List<Paycheck> paycheckList= new ArrayList<>();
    public Staff(){}

    public Staff(Long nationalId, String emailAddress, String firstName, String lastName, String jobTitle, String password){
        setNationalId(nationalId);
        setEmailAddress(emailAddress);
        setFirstName(firstName);
        setLastName(lastName);
        setJobTitle(jobTitle);
        setPassword(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getNationalId() {
        return NationalId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setNationalId(Long nationalId) {
        NationalId = nationalId;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public void setLastWorkingDay(LocalDate lastWorkingDay) {
        this.lastWorkingDay = lastWorkingDay;
    }
}
