package Models;

import java.util.ArrayList;

public abstract class Table {

    private static int currentNumber = 0;
    private int number, capacity;
    private ArrayList<Booking> bookings;
    private TableStatus status;

    //todo:
    //voor een logica laag: een functie die de tafelnummers naast de bookings legt om te zien welke naam e.d. aan een tafel zit
    //====
    //voor aanmaken tafel: tafelnummer genereren door steeds 1 op te hogen. Zoals in guest.

    public Table(){
        this.bookings = new ArrayList<Booking>();
        status = TableStatus.AVAILABLE;
        setNumber();
    }

    public int getNumber() {
        return this.number;
    }
    private void setNumber(){
        this.number = Table.currentNumber + 1;
        Table.currentNumber = this.number;
    }

    public int getCapacity() {
        return this.capacity;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public TableStatus getStatus(){
        return this.status;
    }
    public void changeStatus(TableStatus status){
        this.status = status;
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
