package com.senla.autoservice.service;

import com.senla.autoservice.model.*;
import com.senla.autoservice.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IAdminService {
    void addOrder(Client client, Date time, Date date, Date newDate, State state, Master master, int price);
    void selectOrder(Order order, Garage garage);
    void dellOrder(int tmp);
    void closeOrder(int tmp);
    void undoOrder(int tmp);
    void changeOrderTime(int tmp);
    ArrayList<Garage> getWorkplaces();
    Order getCurrentOrder(int tmp);
    Order getLastOrder();
    void showOrders();

    List<Order> sortedOrder(int tmp);
    void getOrderByMaster(int tmp);
    List<String> getActiveOrdersByTimes(Date firstDate, Date lastDate);
    List<String> getClosedOrdersByTimes(Date firstDate, Date lastDate);
    List<String> getCanceledOrdersByTimes(Date firstDate, Date lastDate);
    void showNearestDate();
}
