package Models;

import java.util.ArrayList;

public abstract class Table {

    private int number, capacity;
    private ArrayList<Booking> bookings;

    public Table(){
        this.bookings = new ArrayList<Booking>();
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
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public ArrayList<Booking> getBookings(){
        return this.bookings;
    }
    public void setBookings(ArrayList<Booking> bookings){
        this.bookings = bookings;
    }
    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }
    public void removeBooking(Booking booking){
        this.bookings.remove(booking);
    }

}
