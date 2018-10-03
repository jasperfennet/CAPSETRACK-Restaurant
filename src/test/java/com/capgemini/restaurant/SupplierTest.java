package com.capgemini.restaurant;

import com.capgemini.restaurant.Models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SupplierTest {
  private Supplier supplier;
  private Address address;

  @BeforeEach
  public void setUp() throws Exception {
    address = new Address("Streetname", 155, "", "541000", "Wuhan", "11", "China");
    supplier = new Supplier("MeatDelivery", address, "+54", "0612345678", "NL12BANK1234567810", "mail@example.com");
  }

  @Test
  public void getName() {
    assertEquals("MeatDelivery", supplier.getName());
  }

  @Test
  public void setName() {
    supplier.setName("MilkDelivery");
    assertEquals("MilkDelivery", supplier.getName());
  }

  @Test
  public void getAddress() {
    assertEquals(address, supplier.getAddress());
  }

  @Test
  public void setAddress() {
    Address address2 = new Address("Streetname", 123, "", "541000", "Wuhan", "11", "China");
    supplier.setAddress(address2);
    assertEquals(address2, supplier.getAddress());
  }

  @Test
  public void getPhoneCountryCode() {
    assertEquals("+54", supplier.getPhoneCountryCode());
  }

  @Test
  public void setPhoneCountryCode() {
    supplier.setPhoneCountryCode("+55");
    assertEquals("+55", supplier.getPhoneCountryCode());
  }

  @Test
  public void getPhoneNumber() {
    assertEquals("0612345678", supplier.getPhoneNumber());
  }

  @Test
  public void setPhoneNumber() {
    supplier.setPhoneNumber("0698765432");
    assertEquals("0698765432", supplier.getPhoneNumber());
  }

  @Test
  public void getBillingNr() {
    assertEquals("NL12BANK1234567810", supplier.getBillingNr());
  }

  @Test
  public void setBillingNr() {
    supplier.setBillingNr("CH12BANK1234567810");
    assertEquals("CH12BANK1234567810", supplier.getBillingNr());
  }
}
