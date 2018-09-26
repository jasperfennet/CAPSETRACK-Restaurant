package com.capgemini.restaurant.Models;

public class Table {

    private int number, capacity;

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
