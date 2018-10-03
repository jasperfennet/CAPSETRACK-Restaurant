package com.capgemini.restaurant.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int number;
    private int capacity;
    private TableStatus status;
    private TableType type;

    public Table() {}

    public Table(int number,TableType type) {
        this.number = number;
        this.capacity = type.getTableCapacity();
        this.status = TableStatus.AVAILABLE;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNumber() {
        return this.number;
    }
    public void setNumber(int number){
        this.number = number;
    }


    public int getCapacity() {
        return this.capacity;
    }

    public TableStatus getStatus(){
        return this.status;
    }

    public void setStatus(TableStatus status){
        this.status = status;
    }

    public TableType getType() {
        return type;
    }

    public void setType(TableType type) {
        this.type = type;
        this.capacity = type.getTableCapacity();
    }


}
