package com.example.hotel.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;
    @Column(nullable = false)
    protected String firstName;
    @Column(nullable = false)
    protected String lastName;
    @Column(nullable = false)
    protected String emailAddress;
    @Column(nullable = false)
    protected String password;
}
