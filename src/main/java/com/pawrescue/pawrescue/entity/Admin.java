
package com.pawrescue.pawrescue.entity;

public class Admin extends User {

    private String adminDepartment;

    public Admin() {
        super();
    }

    public Admin(int userId, String name, String email,
                 String password, String role,
                 String adminDepartment) {

        super(userId, name, email, password, role);
        this.adminDepartment = adminDepartment;
    }

    public String getAdminDepartment() {
        return adminDepartment;
    }

    public void setAdminDepartment(String adminDepartment) {
        this.adminDepartment = adminDepartment;
    }

    public void manageRescue() {
        System.out.println("Admin is managing rescue requests.");
    }

    public void manageVolunteers() {
        System.out.println("Admin is managing volunteers.");
    }
}
