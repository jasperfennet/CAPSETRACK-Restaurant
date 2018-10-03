package com.capgemini.restaurant.Models;

import javax.persistence.Entity;

@Entity
public class Supplier extends Person{

    public Supplier() {
    }

    public Supplier(int id, String firstName, String lastName, String emailAddress, String streetname, int houseNR, String addition, String zipcode, String city, String country, Role role) {
        super(id, firstName, lastName, emailAddress, streetname, houseNR, addition, zipcode, city, country, role);
    }
}
