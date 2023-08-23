package com.Enuma.Model;

import java.util.HashMap;
import java.util.Map;

public class Customer{

    private static Map<String, Integer> shoppingCart = new HashMap<>();

    public Customer() {
    }

  public void makePurchaseOrder(String item) {
      if(new Product().getProductList().containsKey(item)){
          shoppingCart.put(item, new Product().getProductList().get(item));
          System.out.println(item + " Check Out" +'\n');
      } else {
          System.out.println("Out of Stock" + '\n');
        }
  }
  public void completePurchaseOrder() {
      //System.out.println(shoppingCart);
      System.out.println("_______________________________________________");
      System.out.println("Item Details" + "                    " + "Price");
      for (Map.Entry<String, Integer> item : shoppingCart.entrySet()) {
          System.out.println(item.getKey() + "                    " + item.getValue());
      }
      System.out.println("Please proceed to payment" + '\n');
  }
    public static Map<String, Integer> getShoppingCart() {
        return shoppingCart;
    }

}