package com.capgemini.restaurant.Repository;

import com.capgemini.restaurant.Models.*;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class MenuRepository {

    private Map<Integer, MenuItem> menuItems = new HashMap<>();

    @PostConstruct
    public void generateMenuItem() {
        List<Ingredient> ingredients = new ArrayList<>();
        Supplier supplier = new Supplier(
                        "Meat Delivery",
                        new Address("Streetname", 123, "", "541000", "Wuhan", "China"),
                        "0612354678",
                        "NL12BANK1234567810");
        ingredients.add(new Ingredient("Strawberry's", "Kilo", 10, 20.00, supplier, "Strawberry Fever"));
        save(new MenuItem(1,"Chicken", "Chicken",ingredients));
    }

    public void save(MenuItem newMenuItem) {
        this.menuItems.put(newMenuItem.getId(), newMenuItem);
    }

    public Collection<MenuItem> findAll() {
        return this.menuItems.values();
    }

    public MenuItem findByMenuItemNR(int menuItemNR) {
        return this.menuItems.get(menuItemNR);
    }

    public void deleteByMenuItemNR(int menuItemNr) {
        this.menuItems.remove(menuItemNr);
    }

    public MenuItem updateMenuItem(int menuItemNR, MenuItem update) {
        MenuItem menuItem = this.findByMenuItemNR(menuItemNR);
        deleteByMenuItemNR(menuItemNR);
        save(update);

        return update;
    }

}
