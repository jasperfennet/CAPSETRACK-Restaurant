package com.capgemini.restaurant.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String streetname;
    private int houseNR;
    private String addition;
    private String zipcode;
    private String city;
    private String country;

    public Address(){}

    public Address(
            String streetname,
            int houseNR,
            String addition,
            String zipcode,
            String city,
            String country) {
        this.streetname = streetname;
        this.houseNR = houseNR;
        this.addition = addition;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public int getHouseNR() {
        return houseNR;
    }

    public void setHouseNR(int houseNR) {
        this.houseNR = houseNR;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
