package com.Enuma.ServiceImp;

import com.Enuma.Model.CustomerModel;
import com.Enuma.Model.ProductProperties;
import com.Enuma.ServiceImp.Product;
import com.Enuma.SubServices.CATEGORY;

import java.util.HashMap;
import java.util.Map;

public class Customer {


    private CustomerModel customer;

    private Map<String, ProductProperties> shoppingCart = new HashMap<>();

    public Customer(CustomerModel customer) {
        this.customer = customer;
    }

    public Customer() {
    }

    public void makePurchaseOrder(String item, int quantity) {
        if (new Product().getDairy().containsKey(item)) {
            if (new Product().getDairy().get(item).getQuantity() - quantity > 0) {
                if (shoppingCart.containsKey(item)) {
                    shoppingCart.get(item).setQuantity(shoppingCart.get(item).getQuantity() + quantity);
                } else {
                    ProductProperties newProduct = new ProductProperties();
                    newProduct.setName(item);
                    newProduct.setCAT(CATEGORY.DAIRY);
                    newProduct.setPrice(new Product().getDairy().get(item).getPrice());
                    newProduct.setQuantity(quantity);
                    shoppingCart.put(item, newProduct);
                }
                new Product().getDairy().get(item).setQuantity(new Product().getDairy().get(item).getQuantity() - quantity);
                //System.out.println(item + " Order Received" + '\n');
                System.out.println(quantity +" " + item + " Order Received " + new Product().getDairy().get(item).getPrice() * quantity);
                System.out.println();
            }

        }
        else if (new Product().getDrink().containsKey(item)) {
            if (new Product().getDrink().containsKey(item)){
                if (new Product().getDrink().get(item).getQuantity() - quantity > 0) {
                    if (shoppingCart.containsKey(item)) {
                        shoppingCart.get(item).setQuantity(shoppingCart.get(item).getQuantity() + quantity);
                    } else {
                        ProductProperties newProduct = new ProductProperties();
                        newProduct.setName(item);
                        newProduct.setCAT(CATEGORY.DRINK);
                        newProduct.setPrice(new Product().getDrink().get(item).getPrice());
                        newProduct.setQuantity(quantity);
                        shoppingCart.put(item, newProduct);
                    }
                    new Product().getDrink().get(item).setQuantity(new Product().getDrink().get(item).getQuantity() - quantity);
                    // System.out.println(item + " Order Received" + '\n');
                    System.out.println(quantity + " " + item + " Order Placed  " + new Product().getDrink().get(item).getPrice() * quantity);
                    System.out.println();
                }
            }
        }
    else {
      //  System.out.println("Out of Stock" + '\n');
        System.out.println("We do not have " + item + " in stock");
    }
  }

    public void completePurchaseOrder() {
        //System.out.println(shoppingCart);
        System.out.println("_________________________________________________________");
        System.out.printf("%-25s %-25s %-25s","Item Details","Quantity","Price");
        System.out.println();
        for (Map.Entry<String,ProductProperties> item : shoppingCart.entrySet()) {
            System.out.printf("%-25s %-25s %-25s",item.getKey(),item.getValue().getQuantity(), item.getValue().getPrice() * item.getValue().getQuantity());
            System.out.println();
        }
        System.out.println("Please proceed to payment" + '\n');

        customer.setShoppingCart(shoppingCart);

        //FIFO Queue
        new RetailServicesImpl().getCustomersPriorityQueue().add(customer);

        //Priority Queue
        new RetailServicesImpl().getCustomersFIFOQueue().add(customer);
    }
    public  Map<String,ProductProperties> getShoppingCart() {
        return shoppingCart;
    }
}