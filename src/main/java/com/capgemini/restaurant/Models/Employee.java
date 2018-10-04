package com.capgemini.restaurant.Models;

import javax.persistence.Entity;

@Entity
public class Employee extends Person implements Credentials {

    private String username;
    private String password;

    public Employee(){}

    public Employee(int id, String firstName, String lastName, String emailAddress, Address address, Role role, String username, String password) {
        super(id, firstName, lastName, emailAddress, address, role);
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
