package com.capgemini.restaurant.Models;

import javax.persistence.Entity;

@Entity
public class Guest extends Person implements Credentials {

    private String username;
    private String password;

    public Guest(){}
    public Guest(int id, String firstName, String lastName, String emailAddress, String streetname, int houseNR, String addition, String zipcode, String city, String country, Role role, String username, String password) {
        super(id, firstName, lastName, emailAddress, streetname, houseNR, addition, zipcode, city, country, role);
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUserName() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setUserName(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}