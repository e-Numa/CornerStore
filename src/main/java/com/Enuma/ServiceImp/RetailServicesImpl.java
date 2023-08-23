package com.Enuma.ServiceImp;

import com.Enuma.Model.Cashier;
import com.Enuma.Model.Customer;
import com.Enuma.Model.Product;
import com.Enuma.SubServices.RetailServices;

import java.util.Map;

public class RetailServicesImpl implements RetailServices {

    private Cashier cashier;
    public RetailServicesImpl(Cashier cashier) {
        this.cashier = cashier;
    }

    @Override
    public boolean addProducts(String productName, int productPrice) {
        if (!new Product().getProductList().containsKey(productName)){
            new Product().getProductList().put(productName, productPrice);
            return true;
        } else
            System.out.println(productName + " already in stock.");
        return false;
    }

    @Override
    public void issueReceipt(Customer customer) {
        int sum = 0;
        System.out.println("_______________________________________________");
        System.out.println("Item Details" + "                    " + "Price");
        for (Map.Entry<String, Integer> item : new Customer().getShoppingCart().entrySet()) {
            System.out.println(item.getKey() + "                    " + item.getValue());
            sum += item.getValue();
        }
        System.out.println("Total Check Out:" + sum);
        System.out.println("No refunds and exchange after payment.");
        System.out.println("Thank you for your continuous patronage");
    }
}
