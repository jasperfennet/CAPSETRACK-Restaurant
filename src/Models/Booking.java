package Models;

import java.util.Date;
import java.time.*;
import java.util.List;

public class Booking {

    private Guest guest;
    private int id;
    //private Date date;
    private LocalDateTime date;
    private int amountOfPersons;
    private List<Extra> extras;
    private List<Order> orders;
    private List<Table> table;

    public Booking(Guest guest, int id, LocalDateTime date, int amountOfPersons, List<Extra> extras, List<Order> orders, List<Table> table) {
        this.guest = guest;
        this.id = id;
        this.date = date;
        this.amountOfPersons = amountOfPersons;
        this.extras = extras;
        this.orders = orders;
        this.table = table;
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

    public List<Table> getTable() {
        return table;
    }

    public void setTable(List<Table> table) {
        this.table = table;
    }
}
