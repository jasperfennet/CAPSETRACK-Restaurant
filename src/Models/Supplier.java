package Models;

public class Supplier {

    private String name;
    private Address address;
    private String phoneNR;
    private String billingNr;

    public Supplier(String name, Address address, String phoneNR, String billingNr) {
        this.name = name;
        this.address = address;
        this.phoneNR = phoneNR;
        this.billingNr = billingNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNR() {
        return phoneNR;
    }

    public void setPhoneNR(String phoneNR) {
        this.phoneNR = phoneNR;
    }

    public String getBillingNr() {
        return billingNr;
    }

    public void setBillingNr(String billingNr) {
        this.billingNr = billingNr;
    }
}
