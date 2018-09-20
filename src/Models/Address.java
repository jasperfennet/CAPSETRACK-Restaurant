package Models;

public class Address {

  private String streetname;
  private int houseNR;
  private String addition;
  private String zipcode;
  private String city;

  public Address(String streetname, int houseNR, String addition, String zipcode, String city) {
    this.streetname = streetname;
    this.houseNR = houseNR;
    this.addition = addition;
    this.zipcode = zipcode;
    this.city = city;
  }

  public String getStreetname() {
    return streetname;
  }

  public void setStreetname(String streetname) {
    this.streetname = streetname;
  }

  public int getHouseNR() {
    return houseNR;
  }

  public void setHouseNR(int houseNR) {
    this.houseNR = houseNR;
  }

  public String getAddition() {
    return addition;
  }

  public void setAddition(String addition) {
    this.addition = addition;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }
}