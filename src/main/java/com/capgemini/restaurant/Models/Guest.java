package com.capgemini.restaurant.Models;

import javax.persistence.*;

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    @ManyToOne
    private Address address;
    private String password;
    private String phoneCountryCode;
    private String phoneNumber;
    private boolean newsLetter;

    public Guest(){}

    public Guest(String firstName, String lastName, String emailAddress, Address address,
                 String phoneCountryCode, String phoneNumber, boolean newsLetter) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneCountryCode = phoneCountryCode;
        this.phoneNumber = phoneNumber;
        this.newsLetter = newsLetter;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneCountryCode() {
        return phoneCountryCode;
    }

    public void setPhoneCountryCode(String phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isNewsLetter() {
        return newsLetter;
    }

    public void setNewsLetter(boolean newsLetter) {
        this.newsLetter = newsLetter;
    }
}