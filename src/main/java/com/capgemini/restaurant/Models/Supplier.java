package com.capgemini.restaurant.Models;

import javax.persistence.Entity;

@Entity
public class Supplier extends Person{

    public Supplier() {
    }

    public Supplier(int id, String firstName, String lastName, String emailAddress, Address address, Role role) {
        super(id, firstName, lastName, emailAddress, address, role);
    }
}
