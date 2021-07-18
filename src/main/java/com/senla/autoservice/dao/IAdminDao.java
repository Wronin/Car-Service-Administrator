package com.senla.autoservice.dao;

import com.senla.autoservice.model.Garage;
import com.senla.autoservice.model.Master;
import com.senla.autoservice.model.Order;
import com.senla.autoservice.model.*;

import java.util.ArrayList;
import java.util.Date;

public interface IAdminDao {
    void addOrder(Order order);
    void selectOrder(Order order, Garage garage);
    void dellOrder(int tmp);
    Order getCurrentOrder(int tmp);
    Order getLastOrder();
    ArrayList<Order> getOrders();
    void closeOrder(Order order);
    void undoOrder(Order order);
    void changeOrderTime(Order order, Date newDate);
    void showOrders();

    void showOrderByMaster(Master master);
}
