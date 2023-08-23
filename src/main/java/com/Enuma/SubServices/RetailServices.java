package com.Enuma.SubServices;

import com.Enuma.Model.Customer;

public interface RetailServices {
    boolean addProducts (String productName, int productPrice);
    void issueReceipt(Customer customer);
}
