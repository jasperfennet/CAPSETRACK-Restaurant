package com.capgemini.restaurant.Models;

import javax.persistence.Entity;

@Entity
public class Guest extends Person implements Credentials {

    private String username;
    private String password;
    private boolean newsLetter;

    public Guest() {
    }

    public Guest(int id, String firstName, String lastName, String emailAddress, Address address, Role role, String username, String password, String phoneCountryCode, String phoneNumber, boolean newsLetter) {
        super(id, firstName, lastName, emailAddress, address, role, phoneCountryCode, phoneNumber);
        this.username = username;
        this.password = password;
        this.newsLetter = newsLetter;

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

    public boolean isNewsLetter() {
        return newsLetter;
    }

    public void setNewsLetter(boolean newsLetter) {
        this.newsLetter = newsLetter;
    }

}