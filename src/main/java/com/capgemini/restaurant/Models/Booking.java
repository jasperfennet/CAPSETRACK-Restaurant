package com.capgemini.restaurant.Models;


import javax.persistence.*;
import java.util.ArrayList;
import java.time.*;
import java.util.List;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime date;

    @ManyToOne
    private Guest guest;
    private int amountOfPersons;
    @ManyToMany
    private List<Extra> extras;
//    @OneToMany
//    private List<Order> orders;
    @ManyToMany
    private List<Table> table;

    public Booking(){
        this.extras = new ArrayList<>();
//        this.orders = new ArrayList<>();
        this.table = new ArrayList<>();
    }
    public Booking(Guest guest, int id, LocalDateTime date, int amountOfPersons, List<Extra> extras, List<Order> orders, List<Table> table) {
        this.guest = guest;
        this.id = id;
        this.date = date;
        this.amountOfPersons = amountOfPersons;
        this.extras = extras;
//        this.orders = orders;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getAmountOfPersons() {
        return amountOfPersons;
    }

    public void setAmountOfPersons(int amountOfPersons) {
        this.amountOfPersons = amountOfPersons;
    }

//    public List<Order> getOrders() {
//        return orders;
//    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void addExtra(Extra extra) {
        extras.add(extra);
    }

    public void removeExtra(Extra extra) {
        extras.remove(extra);
    }

//    public void addOrder(Order order) {
//        orders.add(order);
//    }
//
//    public void removeOrder(Order order) {
//        orders.remove(order);
//    }

    public List<Table> getTable() {
        return table;
    }
    public void setTable(List<Table> table) {
        this.table = table;
    }
}
