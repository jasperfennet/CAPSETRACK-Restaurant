package com.capgemini.restaurant.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private Address address;
    private String phoneNR;
    private String billingNr;

    public Supplier(){}
    public Supplier(String name, Address address, String phoneNR, String billingNr) {
        this.name = name;
        this.address = address;
        this.phoneNR = phoneNR;
        this.billingNr = billingNr;
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

    public String getPhoneNR() {
        return phoneNR;
    }

    public void setPhoneNR(String phoneNR) {
        this.phoneNR = phoneNR;
    }

    public String getBillingNr() {
        return billingNr;
    }

    public void setBillingNr(String billingNr) {
        this.billingNr = billingNr;
    }
}
