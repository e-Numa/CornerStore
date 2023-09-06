package com.Enuma;

import com.Enuma.Model.Cashier;
import com.Enuma.Model.CustomerModel;
import com.Enuma.ServiceImp.Customer;
import com.Enuma.Model.Manager;
import com.Enuma.ServiceImp.ManagerialServiceImpl;
import com.Enuma.ServiceImp.Product;
import com.Enuma.ServiceImp.RetailServicesImpl;

public class Main {
    public static void main(String[] args) {
        //Manager class imported to the main class
        Manager manager = new Manager("Swizen Bib", (byte) 38, "08153767332", "swizen_bib@cornerstore.co");
        ManagerialServiceImpl MSI = new ManagerialServiceImpl(manager);

        //Cashier class imported to the main class
        Cashier cashier = new Cashier("Adanne Izu", (byte) 27, "08027449870", "adanneIzu@cornerstore.co");
        Cashier cashier1 = new Cashier("Gems Bonsai", (byte) 25, "07061451239", "gems_stone@cornerstore.co");
        Cashier cashier2 =  new Cashier("Genuis Liua", (byte) 28, "08035399565", "genliua@cornerstore.co");

        //Cashier Services imported
        RetailServicesImpl retailServices = new RetailServicesImpl(cashier);


        //New product and store imported
        new Product().addProductsToStore();
        //System.out.println("Dairy");
        //new Product().viewItems(new Product().getDairy()); //Calls the product list from the csv file
        //System.out.println();
        //System.out.println("Drinks");
        //new Product().viewItems(new Product().getDrink()); //Calls the product list from the csv file
        //System.out.println();


        //Customer imported
        Customer customer2 = new Customer(new CustomerModel("Paschal"));
        Customer customer = new Customer(new CustomerModel("Charles"));
        Customer customer1 = new Customer(new CustomerModel("Kingsley"));

        //Manager hires and fires cashier. Where a cashier is not hired, the cashier cannot be fired
        //MSI.hire(cashier);
        //MSI.fire(cashier1);
        //MSI.fire(cashier2);
        //MSI.fire(cashier);
        //MSI.hire(cashier1);

        //Product list modified and stock added/upgraded
        //retailServices.addProducts("Coca Cola", 250);
        //retailServices.addProducts("Indomie Chicken", 300);
        //retailServices.addProducts("Condoms", 500);
        //retailServices.addProducts("Peak Full Cream", 2500);
        //retailServices.addProducts("Golden Morn", 1850);

        //Customer making order
        //customer.makePurchaseOrder("Indomie Chicken");
        //customer.makePurchaseOrder("Coca Cola");
        //customer.makePurchaseOrder("Condoms");
        //customer.makePurchaseOrder("Peak Milk", 4);
        customer2.makePurchaseOrder("Creamora", 4);
        customer2.makePurchaseOrder("Coke", 5);

        customer.makePurchaseOrder("Fanta",5);
        customer.makePurchaseOrder("Bottled Water", 6);

        customer1.makePurchaseOrder("Fanta", 3);
        customer1.makePurchaseOrder("Mozzarella", 2);

        //make a buy request
        customer2.completePurchaseOrder();
        customer1.completePurchaseOrder();
        customer.completePurchaseOrder();

        //retailServices.issueReceipt(customer);
        retailServices.sellFIFO();
        //System.out.println(cashier.getName() + " Dispense Receipt");
    }
}
