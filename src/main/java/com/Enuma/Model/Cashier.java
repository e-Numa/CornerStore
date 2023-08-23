package com.Enuma.Model;

public class Cashier extends Staff{

    private String adminNumber;
    private boolean isHired;

    public Cashier(String name, byte age, String telephone, String email) {
        super(name, age, telephone, email);
    }

    public String getAdminNumber() {
        return adminNumber;
    }

    public void setAdminNumber(String adminNumber) {
        this.adminNumber = adminNumber;
    }

    public boolean getHired() {
        return isHired;
    }

    public void setHired(boolean hired) {
        isHired = hired;
    }
}
