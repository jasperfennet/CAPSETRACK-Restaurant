package com.capgemini.restaurant.Models;

public class Guest {
    public static int currentID = 0;
    private int guestID;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Address address;
    private String password;

    public Guest(){}

    public Guest(String firstName, String lastName, String emailAddress, Address address) {
        setGuestID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
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

    private void setGuestID() {
        this.guestID = Guest.currentID + 1;
        Guest.currentID = this.guestID;
    }

    public int getGuestID() {
        return guestID;
    }


}