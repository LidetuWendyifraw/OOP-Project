package edu.aau;

public class Passenger extends User {
    private String phone;

    public Passenger(String username, String email, String password, String phone) {
        super(username, email, password, "PASSENGER");
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}