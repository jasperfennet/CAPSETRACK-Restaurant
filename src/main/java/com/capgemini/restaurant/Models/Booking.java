package com.capgemini.restaurant.Models;


import javax.persistence.*;
import java.util.Date;
import java.time.*;
import java.util.List;

@Entity
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
<<<<<<< HEAD:src/Models/Booking.java
    //private Date date;
    private LocalDateTime date;
=======
    private Date date;
    @ManyToOne
    private Guest guest;
>>>>>>> spring_bootsetup:src/main/java/com/capgemini/restaurant/Models/Booking.java
    private int amountOfPersons;
    @ManyToMany
    private List<Extra> extras;
    @OneToMany
    private List<Order> orders;
    @ManyToMany
    private List<Table> table;

<<<<<<< HEAD:src/Models/Booking.java
    public Booking(Guest guest, int id, LocalDateTime date, int amountOfPersons, List<Extra> extras, List<Order> orders, List<Table> table) {
=======
    public Booking(){}

    public Booking(Guest guest, int id, Date date, int amountOfPersons, List<Extra> extras, List<Order> orders) {
>>>>>>> spring_bootsetup:src/main/java/com/capgemini/restaurant/Models/Booking.java
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
