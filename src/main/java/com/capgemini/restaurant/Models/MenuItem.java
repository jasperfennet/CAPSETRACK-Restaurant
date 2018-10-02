package com.capgemini.restaurant.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class MenuItem {

<<<<<<< HEAD:src/Models/MenuItem.java
=======
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
>>>>>>> spring_bootsetup:src/main/java/com/capgemini/restaurant/Models/MenuItem.java
    private String name;
    private String menuDescription;
    @ManyToMany
    private List<Ingredient> ingredients;

<<<<<<< HEAD:src/Models/MenuItem.java
    public MenuItem(String name, String menuDescription, List<Ingredient> ingredients) {
=======
    public MenuItem(){}

    public MenuItem(int id, String name, String menuDescription, List<Ingredient> ingredients) {
        this.id = id;
>>>>>>> spring_bootsetup:src/main/java/com/capgemini/restaurant/Models/MenuItem.java
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
