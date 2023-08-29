package com.Enuma;

import com.Enuma.Model.Cashier;
import com.Enuma.Model.Customer;
import com.Enuma.Model.Manager;
import com.Enuma.ServiceImp.ManagerialServiceImpl;
import com.Enuma.ServiceImp.RetailServicesImpl;
import com.Enuma.SubServices.ManagerialServices;

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

        //Customer imported
        Customer customer = new Customer();

        //Manager hires and fires cashier. Where a cashier is not hired, the cashier cannot be fired
        //MSI.hire(cashier);
        //MSI.fire(cashier1);
        //MSI.fire(cashier2);
        //MSI.fire(cashier);
        //MSI.hire(cashier1);

        /*Product list modified and stock added/upgraded
        retailServices.addProducts("Coca Cola", 250);
        retailServices.addProducts("Indomie Chicken", 300);
        retailServices.addProducts("Condoms", 500);
        retailServices.addProducts("Peak Full Cream", 2500);
        retailServices.addProducts("Golden Morn", 1850);*/

        //Customer making order
       /*customer.makePurchaseOrder("Indomie Chicken");
        customer.makePurchaseOrder("Coca Cola");
        customer.makePurchaseOrder("Condoms");*/

        //make a buy request
        customer.completePurchaseOrder();

        retailServices.issueReceipt(customer);
        System.out.println(cashier.getName() + " Dispense Receipt");

        customer.makePurchaseOrder("Fanta 60cl",5);
        customer.makePurchaseOrder("Peak Full Cream Refill 360g", 4);
        customer.makePurchaseOrder("Bottled Water", 6);
    }
}
