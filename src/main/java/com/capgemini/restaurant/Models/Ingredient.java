package com.capgemini.restaurant.Models;

public class Ingredient {

    private String name;
    private String unit;
    private int amount;
    private double price;
    private Supplier supplier;
    private String allergy;

    public Ingredient(
            String name, String unit, int amount, double price, Supplier supplier, String allergy) {
        this.name = name;
        this.unit = unit;
        this.amount = amount;
        this.price = price;
        this.supplier = supplier;
        this.allergy = allergy;
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

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }
}
