package com.Enuma.ServiceImp;

import com.Enuma.Model.ProductProperties;
import com.Enuma.SubServices.CATEGORY;
import com.Enuma.SubServices.ProductManagement;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Product implements ProductManagement {

    private static  Map<String, ProductProperties> dairy = new HashMap<>();
    private static  Map<String, ProductProperties> drink = new HashMap<>();

    public Product() {

    }
//    public static Map<String, ProductProperties> getProductList() {
//        return productList;
//    }

    public Map<String, ProductProperties> getDairy() {
        return dairy;
    }

    public Map<String, ProductProperties> getDrink() {
        return drink;
    }

    @Override
    public boolean addProductsToStore() {
        //this reads the CSV file - we are able to implement this through product file
        File file = new File("./src/main/resources/productList.csv");
        String line = "";

        //exception handling
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            //read the file into a line
            while((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                //System.out.println(Arrays.toString(row));

                if (!row[0].equalsIgnoreCase("name")) {
                    if (row[1].equalsIgnoreCase("dairy")) {
                        ProductProperties newProduct = new ProductProperties();
                        newProduct.setName(row[0]);
                        newProduct.setCAT(CATEGORY.DAIRY);
                        newProduct.setPrice(Integer.parseInt(row[2]));
                        newProduct.setQuantity(Integer.parseInt(row[3]));
                        //System.out.println(newProduct);

                        //adding created product to dairy map
                        dairy.put(row[0], newProduct);
                    }
                    if (row[1].equalsIgnoreCase("drink")) {
                        ProductProperties newProduct = new ProductProperties();
                        newProduct.setName(row[0]);
                        newProduct.setCAT(CATEGORY.DRINK);
                        newProduct.setPrice(Integer.parseInt(row[2]));
                        newProduct.setQuantity(Integer.parseInt(row[3]));
                        //System.out.println(newProduct);

                        //adding created product to drink map
                        drink.put(row[0], newProduct);
                    }

                    return true;
                }

            }

        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e); - to be replaced with "sout" or you can use e.printStackTrace();
            System.out.println("File not found" + e);
        } catch (IOException e) {
            //throw new RuntimeException(e); to be replaced with "sout"
            System.out.println("Input or Output error" + e);
        }
        return false;
    }
        @Override
    public boolean updateStoreRecords() {
        return false;
    }

    public void viewItems(Map<String, ProductProperties> productPropertiesMap){
        for(var item: productPropertiesMap.values()){
            System.out.printf("%-25s %-25s %-25s", item.getName(),item.getPrice(),item.getQuantity());
        }
    }
}
