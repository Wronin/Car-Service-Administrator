package com.senla.autoservice.controller.realizations;

import com.senla.autoservice.composition.annotations.InjectByClassType;
import com.senla.autoservice.composition.annotations.Singleton;
import com.senla.autoservice.model.Client;
import com.senla.autoservice.model.Master;
import com.senla.autoservice.model.Order;
import com.senla.autoservice.model.State;
import com.senla.autoservice.model.*;
import com.senla.autoservice.controller.IAdminController;
import com.senla.autoservice.service.IAdminService;

import java.util.Date;

@Singleton
public class AdminController implements IAdminController {

    @InjectByClassType
    private IAdminService adminService;

    @Override
    public void addOrder(Client client, Date time, Date date, Date newDate, State state, Master master, int price) {
        adminService.addOrder(client, time, date, newDate, state, master, price);
    }

    @Override
    public void deleteOrder(int tmp) {
        adminService.dellOrder(tmp);
    }

    @Override
    public Order getLastOrder() {
        return adminService.getLastOrder();
    }

    @Override
    public void showOrders() {adminService.showOrders();}

    @Override
    public void changeOrderTime(int tmp) {adminService.changeOrderTime(tmp);}
}
