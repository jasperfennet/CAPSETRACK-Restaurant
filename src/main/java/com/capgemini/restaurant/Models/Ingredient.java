package com.capgemini.restaurant.Models;

import javax.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String unit;
    private int amount;
    private double price;
    @ManyToMany
    private Supplier supplier;
    @ManyToMany
    private Allergy allergy;

    public Ingredient(){}
    public Ingredient(
            String name, String unit, int amount, double price, Supplier supplier, Allergy allergy) {
        this.name = name;
        this.unit = unit;
        this.amount = amount;
        this.price = price;
        this.supplier = supplier;
        this.allergy = allergy;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Allergy getAllergy() {
        return allergy;
    }

    public void setAllergy(Allergy allergy) {
        this.allergy = allergy;
    }
}