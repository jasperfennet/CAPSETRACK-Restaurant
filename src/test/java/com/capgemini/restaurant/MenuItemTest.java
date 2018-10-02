package com.capgemini.restaurant;

import com.capgemini.restaurant.Models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemTest {

    private MenuItem menuItem;

    @BeforeEach
    public void setUp() throws Exception {
        Address address = new Address("Streetname", 155, "", "541000", "Wuhan", "China");
        Supplier supplier = new Supplier("MeatDelivery", address, "0612345678", "NL12BANK1234567810");

        Ingredient ingr1 = new Ingredient("Carrot", "grams", 1000, 0.50d, supplier, "none");
        Ingredient ingr2 = new Ingredient("Milk", "liters", 10, 1.00d, supplier, "lactose");

        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(ingr1);
        ingredients.add(ingr2);

        menuItem = new MenuItem(1, "Menu", "Description", ingredients);
    }

    @Test
    void getMenuDescription() {
    }

    @Test
    void setMenuDescription() {
    }

    @Test
    void getIngredientList() {
    }

    @Test
    void setIngredientList() {
    }

    @Test
    void addIngredient() {
    }

    @Test
    void removeIngredient() {
    }

    @Test
    void getName() {
    }

    @Test
    void setName() {
    }
}