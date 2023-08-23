package com.Enuma;

import com.Enuma.Model.Cashier;
import com.Enuma.Model.Manager;
import com.Enuma.ServiceImp.ManagerialServiceImpl;
import com.Enuma.SubServices.ManagerialServices;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("Swizen Bib", (byte) 38, "08153767332", "swizen_bib@cornerstore.co");
        ManagerialServiceImpl MSI = new ManagerialServiceImpl(manager);


        Cashier cashier = new Cashier("Adanne Izu", (byte) 27, "08027449870", "adanneIzu@cornerstore.co");
        Cashier cashier1 = new Cashier("Gems Bonsai", (byte) 25, "07061451239", "gems_stone@cornerstore.co");
        Cashier cashier2 =  new Cashier("Genuis Liua", (byte) 28, "08035399565", "genliua@cornerstore.co");

         MSI.hire(cashier);
         MSI.fire(cashier1);
      // MSI.fire(cashier2);
         MSI.fire(cashier);
       //MSI.hire(cashier1);
    }
}
