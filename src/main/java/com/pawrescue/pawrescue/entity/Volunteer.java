
package com.pawrescue.pawrescue.entity;

import jakarta.persistence.Entity;

@Entity
public class Volunteer extends User {

    private String phone;
    private String location;
    private boolean available;

    public Volunteer() {
        super();
    }

    public Volunteer(int userId, String name, String email,
                     String password, String role,
                     String phone, String location,
                     boolean available) {

        super(userId, name, email, password, role);

        this.phone = phone;
        this.location = location;
        this.available = available;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void acceptRescue() {
        System.out.println("Volunteer accepted the rescue request!");
    }
}
