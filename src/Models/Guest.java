package Models;

public class Guest {
    public static int currentID = 0;
    private int guestID;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address;
    private String postCode;
    private String city;


    /* Three constructors:
    Only fist name and last name
    Only fist name, last name and email address
    All fields
     */

    // Constructor for only first name and last name
    public Guest(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        setGuestID();

    }

    // Constructor for only fist name, last name and email address
    public Guest(String firstName, String lastName, String emailAddress) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmailAddress(emailAddress);
        setGuestID();
    }

    // Constructor for all fields
    public Guest(String firstName, String lastName, String emailAddress,
                           String address, String postCode, String city) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmailAddress(emailAddress);
        setAddress(address);
        setPostCode(postCode);
        setCity(city);
        setGuestID();
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private void setGuestID() {
        this.guestID = Guest.currentID + 1;
        Guest.currentID = this.guestID;
    }

    public int getGuestID() { return guestID; }


}