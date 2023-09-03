package com.Enuma.ServiceImp;

import com.Enuma.Model.Cashier;
import com.Enuma.Model.Customer;
import com.Enuma.Model.ProductProperties;
import com.Enuma.SubServices.RetailServices;

import java.util.Map;

public class RetailServicesImpl implements RetailServices {
    private Cashier cashier;

    public RetailServicesImpl(Cashier cashier) {
        this.cashier = cashier;
    }
    public RetailServicesImpl(){

    }

    @Override
    public boolean addProducts() {

        if (new Product().addProductsToStore()) {
            System.out.println("Stock added Successfully");
            return true;
        } else {
            System.out.println("Error adding stock");
            return false;
        }
    }

    @Override
    public void issueReceipt(Customer customer) {
        int sum = 0;
        System.out.println("_______________________________");
        System.out.printf("%-25s %-25s","Item Details","Price");
        System.out.println();
        for (Map.Entry<String,ProductProperties> item : customer.getShoppingCart().entrySet()) {

            String itemName = item.getKey();
            ProductProperties product = item.getValue();

            if (product.getQuantity()>0){
                System.out.printf("%-25s %-25s",itemName,product.getPrice() * product.getQuantity());
                System.out.println();
                sum += item.getValue().getQuantity()* product.getPrice();
            }
            else {
                System.out.println("Please include how much " +itemName+ " quantity you need");
            }
        }
        System.out.println("Total Check Out:          "        + sum + '\n');
        System.out.println("No refunds and exchange after payment.");
        System.out.println("Thank you for your continuous patronage" + '\n');
    }
}

