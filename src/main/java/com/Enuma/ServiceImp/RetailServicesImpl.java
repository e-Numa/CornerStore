package com.Enuma.ServiceImp;

import com.Enuma.Model.Cashier;
import com.Enuma.Model.CustomerModel;
import com.Enuma.Model.ProductProperties;
import com.Enuma.SubServices.RetailServices;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RetailServicesImpl implements RetailServices {
    private Cashier cashier;

    private static Queue<CustomerModel> customersFIFOQueue = new LinkedList<>();
    private static Queue<CustomerModel> customersPriorityQueue = new PriorityQueue<>();

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

    public void sellFIFO(){
        while (!customersFIFOQueue.isEmpty()) {
            CustomerModel currentCustomer = customersFIFOQueue.poll();
            Map<String, ProductProperties> myshoppingCart = currentCustomer.getShoppingCart();
            String fullName = currentCustomer.getFullName();
            issueReceipt(myshoppingCart, fullName);
        }
    }

    public void sellPriority() {
        while (!customersPriorityQueue.isEmpty()) {
            CustomerModel currentCustomer = customersPriorityQueue.poll();
            Map<String, ProductProperties> myshoppingCart = currentCustomer.getShoppingCart();
            String fullName = currentCustomer.getFullName();
            issueReceipt(myshoppingCart, fullName);
        }
    }
    private void issueReceipt(Map<String, ProductProperties> shoppingCart, String fullName) {
    int sum = 0;
        System.out.println("_______________________________");
        System.out.printf("%-25s %-25s","Item Details","Price");
        System.out.println();
        for (Map.Entry<String,ProductProperties> item : shoppingCart.entrySet()) {

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
        System.out.println("Thank you " + fullName + " for your continuous patronage" + '\n');
    }

    public Queue<CustomerModel> getCustomersFIFOQueue() {
        return customersFIFOQueue;
    }

    public Queue<CustomerModel> getCustomersPriorityQueue() {
        return customersPriorityQueue;
    }
}


