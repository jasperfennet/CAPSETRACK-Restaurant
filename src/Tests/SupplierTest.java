package Tests;

import Models.Address;
import Models.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupplierTest {
  private Supplier supplier;
  private Address address;

  @BeforeEach
  public void setUp() throws Exception {
    address = new Address("Streetname", 155, "", "541000", "Wuhan");
    supplier = new Supplier("MeatDelivery", address, "0612345678", "NL12BANK1234567810");
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
    Address address2 = new Address("Streetname", 123, "", "541000", "Wuhan");
    supplier.setAddress(address2);
    assertEquals(address2, supplier.getAddress());
  }

  @Test
  public void getPhoneNR() {
    assertEquals("0612345678", supplier.getPhoneNR());
  }

  @Test
  public void setPhoneNR() {
    supplier.setPhoneNR("0698765432");
    assertEquals("0698765432", supplier.getPhoneNR());
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
