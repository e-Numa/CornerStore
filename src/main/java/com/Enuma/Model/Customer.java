package com.Enuma.Model;

import com.Enuma.ServiceImp.Product;
import com.Enuma.SubServices.CATEGORY;

import java.util.HashMap;
import java.util.Map;

public class Customer {

    private static Map<String, ProductProperties> shoppingCart = new HashMap<>();

    public Customer() {
    }

    public void makePurchaseOrder(String item, int quantity) {
        if (new Product().getDairy().containsKey(item)) {
            if (new Product().getDairy().get(item).getQuantity() - quantity >= 0) {
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
                System.out.println(item + " Order Received" + '\n');
            }

        } else if (new Product().getDrink().containsKey(item)) {
            if (new Product().getDrink().get(item).getQuantity() - quantity >= 0) {
                if (shoppingCart.containsKey(item)) {
                    shoppingCart.get(item).setQuantity(shoppingCart.get(item).getQuantity() + quantity);
                } else {
                    ProductProperties newProduct = new ProductProperties();
                    newProduct.setName(item);
                    newProduct.setCAT(CATEGORY.DRINK);
                    newProduct.setPrice(new Product().getDairy().get(item).getPrice());
                    newProduct.setQuantity(quantity);

                    shoppingCart.put(item, newProduct);
            }
            new Product().getDrink().get(item).setQuantity(new Product().getDrink().get(item).getQuantity() - quantity);
            System.out.println(item + " Order Received" + '\n');
        }

    } else {
        System.out.println("Out of Stock" + '\n');
    }
  }

    public void completePurchaseOrder() {
        //System.out.println(shoppingCart);
        System.out.println("_______________________________");
        System.out.printf("%-25s %-25s","Item Details","Price");
        System.out.println();
        for (Map.Entry<String,ProductProperties> item : shoppingCart.entrySet()) {
            System.out.printf("%-25s %-25s",item.getKey(),item.getValue());
            System.out.println();
        }
        System.out.println("Please proceed to payment" + '\n');
    }
    public static Map<String,ProductProperties> getShoppingCart() {
        return shoppingCart;
    }

}