package com.Enuma.ServiceImp;

import com.Enuma.Model.Cashier;
import com.Enuma.Model.Customer;
import com.Enuma.Model.ProductProperties;
import com.Enuma.SubServices.RetailServices;

import java.util.Map;

public class RetailServicesImpl implements RetailServices {

    public RetailServicesImpl(Cashier cashier) {
    }

    @Override
    public boolean addProducts() {

        if (new Product().addProductsToStore()) {
            System.out.println("Stock added Successfully");
            return true;
        } else
            System.out.println("Error adding stock");
        return false;
    }

    @Override
    public void issueReceipt(Customer customer) {
        int sum = 0;
        System.out.println("_______________________________");
        System.out.printf("%-25s %-25s","Item Details","Price");
        System.out.println();
        for (Map.Entry<String,ProductProperties> item : customer.getShoppingCart().entrySet()) {
            System.out.printf("%-25s %-25s",item.getKey(),item.getValue());
            System.out.println();
            //sum += item.getValue();
        }
        System.out.println("Total Check Out: " + sum + '\n');
        System.out.println("No refunds and exchange after payment.");
        System.out.println("Thank you for your continuous patronage" + '\n');
    }
}

