package com.capgemini.restaurant.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class Booking {

    private Guest guest;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private Date date;
    private int amountOfPersons;
    private List<Extra> extras;
    private List<Order> orders;
    private List<Table> table;

    public Booking(){}

    public Booking(Guest guest, int id, Date date, int amountOfPersons, List<Extra> extras, List<Order> orders) {
        this.guest = guest;
        this.id = id;
        this.date = date;
        this.amountOfPersons = amountOfPersons;
        this.extras = extras;
        this.orders = orders;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmountOfPersons() {
        return amountOfPersons;
    }

    public void setAmountOfPersons(int amountOfPersons) {
        this.amountOfPersons = amountOfPersons;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void addExtra(Extra extra) {
        extras.add(extra);
    }

    public void removeExtra(Extra extra) {
        extras.remove(extra);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }
}
