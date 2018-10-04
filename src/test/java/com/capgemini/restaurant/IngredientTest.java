package com.capgemini.restaurant;

import com.capgemini.restaurant.Models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientTest {
  private List<Ingredient> ingredients = new ArrayList<>();
  private List<Supplier> suppliers = new ArrayList<>();
  private List<Allergy> allergies = new ArrayList<>();

  @BeforeEach
  public void setUp() throws Exception {
    suppliers.add(new Supplier(
            "Meat Delivery",
            new Address("Streetname", 123, "", "541000", "Wuhan", "11", "China"),
            "+54", "0612354678","NL12BANK1234567810", "mail@example.com"));
    allergies.add(new Allergy("Strawberry Fever"));
    ingredients.add(new Ingredient("Strawberry's", "Kilo", 10, 20.00, suppliers, allergies));
  }

  @Test
  public void getName() {
    assertEquals("Strawberry's", ingredients.get(0).getName());
  }

  @Test
  public void setName() {
    ingredients.get(0).setName("Blue Strawberry's");
    assertEquals("Blue Strawberry's", ingredients.get(0).getName());
  }

  @Test
  public void getUnit() {
    assertEquals("Kilo", ingredients.get(0).getUnit());
  }

  @Test
  public void setUnit() {
    ingredients.get(0).setUnit("Liter");
    assertEquals("Liter", ingredients.get(0).getUnit());
  }

  @Test
  public void getAmount() {
    assertEquals(10, ingredients.get(0).getAmount());
  }

  @Test
  public void setAmount() {
    ingredients.get(0).setAmount(15);
    assertEquals(15, ingredients.get(0).getAmount());
  }

  @Test
  public void getPrice() {
    assertEquals(20.00, ingredients.get(0).getPrice());
  }

  @Test
  public void setPrice() {
    ingredients.get(0).setPrice(21.00);
    assertEquals(21.00, ingredients.get(0).getPrice());
  }

  @Test
  public void getSupplier() {
    assertEquals(suppliers, ingredients.get(0).getSuppliers());
  }

  @Test
  public void setSupplier() {
    suppliers.add(new Supplier(
            "Meat Delivery",
            new Address("Streetname", 123, "", "541000", "Wuhan", "11", "China"),
            "+54", "0612354678", "NL12BANK1234567810", "mail@example.com"));

    ingredients.get(0).setSuppliers(suppliers);
    assertEquals(suppliers, ingredients.get(0).getSuppliers());
  }

  @Test
  public void getAllergy() {
    assertEquals("Strawberry Fever", ingredients.get(0).getAllergies());
  }

  @Test
  public void setAllergy() {
    allergies.add(new Allergy("Milk"));
    ingredients.get(0).setAllergies(allergies);
    assertEquals(allergies, ingredients.get(0).getAllergies());
  }
}
