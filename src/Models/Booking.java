package Models;

import java.util.Date;

public class Booking {

    private Guest guest;
    private int id;
    private Date date;
    private int amountOfPersons;
    private Extra extra;
//    private Bestelling bestelling;

    public Booking(Guest guest, int id, Date date, int amountOfPersons, Extra extra) {
        this.guest = guest;
        this.id = id;
        this.date = date;
        this.amountOfPersons = amountOfPersons;
        this.extra = extra;

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

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }
}
