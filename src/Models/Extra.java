package Models;

import java.util.ArrayList;

public class Extra {

    public static ArrayList<Extra> extraItems = new ArrayList<>();

    private String name;
    private double price;

    public Extra(String name, double price) {
        this.name = name;
        this.price = price;
        extraItems.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Extra{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
