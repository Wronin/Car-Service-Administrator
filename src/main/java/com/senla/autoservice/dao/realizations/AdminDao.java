package com.senla.autoservice.dao.realizations;

import com.senla.autoservice.composition.annotations.Singleton;
import com.senla.autoservice.dao.IAdminDao;
import com.senla.autoservice.model.Garage;
import com.senla.autoservice.model.Master;
import com.senla.autoservice.model.Order;
import com.senla.autoservice.model.State;
import com.senla.autoservice.model.*;

import java.util.ArrayList;
import java.util.Date;

@Singleton
public class AdminDao implements IAdminDao {

    private ArrayList<Order> orders = new ArrayList<Order>();

    public AdminDao() {
    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void selectOrder(Order order, Garage garage) {
        garage.setOrder(order);
    }

    @Override
    public void dellOrder(int tmp) {
        orders.remove(tmp);
    }

    @Override
    public Order getCurrentOrder(int tmp) { return orders.get(tmp); }

    @Override
    public Order getLastOrder() {
        return orders.get(orders.size() - 1);
    }

    @Override
    public ArrayList<Order> getOrders() {
        return orders;
    }

    @Override
    public void closeOrder(Order order) {
        order.setState(State.CLOSED_ORDER);
    }

    @Override
    public void undoOrder(Order order) {
        order.setState(State.CANCELLED_ORDER);
    }

    @Override
    public void changeOrderTime(Order order, Date newDate) { order.setNewDate(newDate); }

    @Override
    public void showOrders() {
        System.out.println(orders.toString());
    }

    @Override
    public void showOrderByMaster(Master master) {
        for (Order order : orders) {
            if (order.getMaster().getName() != null)
                if (order.getMaster().getName().equals(master.getName()) && order.getState().equals(State.ACTIVE_ORDER))
                    System.out.println(order.toString());
        }
    }

}
