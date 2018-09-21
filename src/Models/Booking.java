package Models;

import java.util.ArrayList;
import java.util.Date;

public class Booking {

  public static ArrayList<Booking> bookingList = new ArrayList<>();

  private Guest guest;
  private int id;
  private Date date;
  private int amountOfPersons;
  private ArrayList<Extra> extras;
  private ArrayList<Order> orders;

  public Booking(
      Guest guest,
      int id,
      Date date,
      int amountOfPersons,
      ArrayList<Extra> extras,
      ArrayList<Order> orders) {
    this.guest = guest;
    this.id = id;
    this.date = date;
    this.amountOfPersons = amountOfPersons;
    this.extras = extras;
    this.orders = orders;
    bookingList.add(this);
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

  public ArrayList<Order> getOrders() {
    return orders;
  }

  public ArrayList<Extra> getExtras() {
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

    @Override
    public String toString() {
        return "Booking{" +
                "Guest:=" + guest +
                ",BookingID=" + id +
                ",BookingDate=" + date +
                ",amountOfPersons=" + amountOfPersons +
                ",extras=" + extras +
                ",orders=" + orders +
                '}';
    }
}
