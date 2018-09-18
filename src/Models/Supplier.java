package Models;

public class Supplier {

    private String name;
    private Address address;
    private String phoneNR;
    private String rekeningNr;

    public Supplier(String name, Address address, String phoneNR, String rekeningNr) {
        this.name = name;
        this.address = address;
        this.phoneNR = phoneNR;
        this.rekeningNr = rekeningNr;
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

    public String getRekeningNr() {
        return rekeningNr;
    }

    public void setRekeningNr(String rekeningNr) {
        this.rekeningNr = rekeningNr;
    }
}
