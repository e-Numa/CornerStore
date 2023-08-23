package com.Enuma.Model;

import java.util.HashMap;
import java.util.Map;

public class Product {

    private static Map<String, Integer> productList = new HashMap<>();

    public Product() {

    }
    public static Map<String, Integer> getProductList() {
        return productList;
    }
}
