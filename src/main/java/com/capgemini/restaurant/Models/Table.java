package com.capgemini.restaurant.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int number;
    private int capacity;

    public Table() {}

    public Table(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
