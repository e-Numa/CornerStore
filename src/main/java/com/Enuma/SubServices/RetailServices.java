package com.Enuma.SubServices;

import com.Enuma.Model.Customer;

public interface RetailServices {
    boolean addProducts ();
    void issueReceipt(Customer customer);
}
