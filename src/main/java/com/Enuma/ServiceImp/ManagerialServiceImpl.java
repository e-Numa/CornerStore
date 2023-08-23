package com.Enuma.ServiceImp;

import com.Enuma.Model.Cashier;
import com.Enuma.Model.Manager;
import com.Enuma.SubServices.ManagerialServices;

public class ManagerialServiceImpl implements ManagerialServices {
    private Manager manager;

    public ManagerialServiceImpl(Manager manager) {
        this.manager=manager;
    }

    @Override
    public void hire(Cashier cashier) {
        cashier.setHired(true);
        System.out.println(cashier.getName() + ", Congratulations! You have been hired!" + '\n');

    }

    @Override
    public void fire(Cashier cashier) {
        if (cashier.getHired()) {
            cashier.setHired(false);
            System.out.println(cashier.getName() + ", Sorry! You are fired!" + '\n');
        } else
            System.out.println(cashier.getName() + "! No record found!" + '\n');
    }
}
