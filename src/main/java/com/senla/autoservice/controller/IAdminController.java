package com.senla.autoservice.controller;

import com.senla.autoservice.model.Client;
import com.senla.autoservice.model.Master;
import com.senla.autoservice.model.Order;
import com.senla.autoservice.model.State;

import java.util.Date;

public interface IAdminController {

    void addOrder(Client client, Date time, Date date, Date newDate, State state, Master master, int price);
    void deleteOrder(int tmp);
    Order getLastOrder();
    void showOrders();
    void changeOrderTime(int tmp);

}
