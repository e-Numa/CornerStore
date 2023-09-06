package com.Enuma.Model;

import java.util.Map;

public class CustomerModel  implements Comparable<CustomerModel> {

    private String fullName;
    private int ID;
    private Map<String, ProductProperties> shoppingCart;
    private static int count = 0;
    private int quantity;

    public CustomerModel(String fullName, int ID, Map<String, ProductProperties> shoppingCart, int quantitiy) {
        this.fullName = fullName;
        this.shoppingCart = shoppingCart;
        //this.ID = count++;
    }

    public CustomerModel(String fullName) {
        this.fullName = fullName;
        this.ID = count++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getID() {
        return ID;
    }

    public void setShoppingCart(Map<String, ProductProperties> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Map<String, ProductProperties> getShoppingCart() {
        return shoppingCart;
    }

    private int getshoppingCartQuantity() {
        for (var item : shoppingCart.values()) {
            quantity += item.getQuantity();
        }
        return quantity;
    }

    @Override
    public int compareTo(CustomerModel o) {
        if (this.getshoppingCartQuantity() > o.getshoppingCartQuantity()) {
            return 1;
        } else if (this.getshoppingCartQuantity() < o.getshoppingCartQuantity()) {
            return -1;
        } else
            return 0;
    }
}