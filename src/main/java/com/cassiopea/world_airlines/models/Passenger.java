package com.cassiopea.world_airlines.models;
import com.cassiopea.world_airlines.enumerations.Gender;

import java.util.Date;

public class Passenger {

    private String username ;
    private String email ;
    private String password ;
    private Date dateOfBirth ;
    private Gender gender ;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return username ;
    }
    public Passenger(String username, String email, String password, Date dateOfBirth, Gender gender) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public Passenger() {
        super();
        // Default constructor
    }
}
