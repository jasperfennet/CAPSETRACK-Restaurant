package com.capgemini.restaurant.Models;

import javax.persistence.*;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToOne
    private Address address;
    private String phoneCountryCode;
    private String phoneNumber;
    private String billingNr;
    private String emailAddress;

    public Supplier(){}
    public Supplier(String name, Address address, String phoneCountryCode, String phoneNumber,
                    String billingNr, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneCountryCode = phoneCountryCode;
        this.phoneNumber = phoneNumber;
        this.billingNr = billingNr;
        this.emailAddress = emailAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneCountryCode() {
        return phoneCountryCode;
    }

    public void setPhoneCountryCode(String phoneNR) {
        this.phoneCountryCode = phoneCountryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBillingNr() {
        return billingNr;
    }

    public void setBillingNr(String billingNr) {
        this.billingNr = billingNr;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
