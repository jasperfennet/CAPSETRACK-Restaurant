package com.capgemini.restaurant;

import com.capgemini.restaurant.Models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientTest {
  private Ingredient ingredient;
  private Supplier supplier;

  @BeforeEach
  public void setUp() throws Exception {
    supplier =
        new Supplier(
            "Meat Delivery",
            new Address("Streetname", 123, "", "541000", "Wuhan", "11", "China"),
            "+54", "0612354678","NL12BANK1234567810", "mail@example.com");
    Allergy strawberryFever = new Allergy("Strawberry Fever");
    ingredient = new Ingredient("Strawberry's", "Kilo", 10, 20.00, supplier, strawberryFever);
  }

  @Test
  public void getName() {
    assertEquals("Strawberry's", ingredient.getName());
  }

  @Test
  public void setName() {
    ingredient.setName("Blue Strawberry's");
    assertEquals("Blue Strawberry's", ingredient.getName());
  }

  @Test
  public void getUnit() {
    assertEquals("Kilo", ingredient.getUnit());
  }

  @Test
  public void setUnit() {
    ingredient.setUnit("Liter");
    assertEquals("Liter", ingredient.getUnit());
  }

  @Test
  public void getAmount() {
    assertEquals(10, ingredient.getAmount());
  }

  @Test
  public void setAmount() {
    ingredient.setAmount(15);
    assertEquals(15, ingredient.getAmount());
  }

  @Test
  public void getPrice() {
    assertEquals(20.00, ingredient.getPrice());
  }

  @Test
  public void setPrice() {
    ingredient.setPrice(21.00);
    assertEquals(21.00, ingredient.getPrice());
  }

  @Test
  public void getSupplier() {
    assertEquals(supplier, ingredient.getSupplier());
  }

  @Test
  public void setSupplier() {
    Supplier supplier2 =
        new Supplier(
            "Meat Delivery",
            new Address("Streetname", 123, "", "541000", "Wuhan", "11", "China"),
            "+54", "0612354678", "NL12BANK1234567810", "mail@example.com");

    ingredient.setSupplier(supplier2);
    assertEquals(supplier2, ingredient.getSupplier());
  }

  @Test
  public void getAllergy() {
    assertEquals("Strawberry Fever", ingredient.getAllergy());
  }

  @Test
  public void setAllergy() {
    Allergy blueStrawberryFever = new Allergy("Blue Strawberry Fever");
    ingredient.setAllergy(blueStrawberryFever);
    assertEquals(blueStrawberryFever, ingredient.getAllergy());
  }
}
