package com.capgemini.restaurant.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String menuDescription;
    private List<Ingredient> ingredients;

    public MenuItem(){}

    public MenuItem(int id, String name, String menuDescription, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.menuDescription = menuDescription;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenuDescription() {
        return this.menuDescription;
    }

    public void setMenuDescription(String description) {
        this.menuDescription = description;
    }

    public List<Ingredient> getIngredientList() {
        return this.ingredients;
    }

    public void setIngredientList(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        this.ingredients.remove(ingredient);
    }
}
