package com.senla.autoservice.service.realizations;

import com.senla.autoservice.dao.IAdminDao;
import com.senla.autoservice.composition.annotations.ConfigProperty;
import com.senla.autoservice.composition.annotations.InjectByClassType;
import com.senla.autoservice.composition.annotations.Singleton;
import com.senla.autoservice.dao.realizations.AdminDao;
import com.senla.autoservice.model.*;
import com.senla.autoservice.model.*;
import com.senla.autoservice.service.IAdminService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

@Singleton
public class AdminService implements IAdminService {

    private static final Logger logger = LogManager.getLogger(MasterService.class);

    public AdminService() {
    }

    @InjectByClassType
    private IAdminDao iAdminDao;

    @ConfigProperty(PropertyName = "AdminService.canChangeTimeOfOrders", classType = Integer.class)
    Integer canChangeTimeOfOrders;

    @ConfigProperty(PropertyName = "AdminService.canChangeCountOfOrders", classType = Integer.class)
    Integer canChangeCountOfOrders;
    private final Calendar calendar = new GregorianCalendar();

    @Override
    public void addOrder(Client client, Date time, Date date, Date newDate, State state, Master master, int price) {
        try {
            calendar.setTime(date);
            calendar.roll(Calendar.DAY_OF_MONTH, 2);
            newDate = calendar.getTime();

            master.setFree(0);

            iAdminDao.addOrder(new Order(client, time, date, newDate, state, master, price));
            logger.info("added order");
        } catch (Exception msg) {
            logger.error(msg.getMessage());
        }
    }

    @Override
    public void selectOrder(Order order, Garage garage) {
//        iAdminDao.selectOrder(order, garage);
    }

    @Override
    public void dellOrder(int tmp) {
        try {
            if (canChangeTimeOfOrders == 1) {
                iAdminDao.dellOrder(tmp);
                logger.info("order deleted");
            }
        } catch (Exception msg) {
            logger.error(msg.getMessage());
        }
    }

    @Override
    public void closeOrder(int tmp) {
//        iAdminDao.closeOrder(iAdminDao.getCurrentOrder(tmp));
    }

    @Override
    public void undoOrder(int tmp) {
//        iAdminDao.undoOrder(iAdminDao.getCurrentOrder(tmp));
    }

    @Override
    public void changeOrderTime(int tmp) {
        try {
            if (canChangeCountOfOrders == 1) {
                Date newDate;
                calendar.roll(Calendar.DAY_OF_MONTH, 2);
                newDate = calendar.getTime();
                iAdminDao.changeOrderTime(iAdminDao.getCurrentOrder(tmp), newDate);
                logger.info("changed date");
            }
        } catch (Exception msg) {
            logger.error(msg.getMessage());
        }
    }

    @Override
    public ArrayList<Garage> getWorkplaces() {
        return new ArrayList<>();
//        return iOrganizationDao.getWorkplaces();
    }

    @Override
    public Order getCurrentOrder(int tmp) {
        return new Order();
//        return iAdminDao.getCurrentOrder(tmp);
    }

    @Override
    public Order getLastOrder() {
        return iAdminDao.getLastOrder();
    }

    @Override
    public void showOrders() {
        try {
            iAdminDao.showOrders();
            logger.info("showed Orders");
        } catch (Exception msg) {
            logger.error(msg.getMessage());
        }
    }

    @Override
    public List<Order> sortedOrder(int tmp) {
        List<Order> orders = null;
//        = iAdminDao.getOrders();
//        switch (tmp) {
//            case 1 -> orders.sort(Comparator.comparing(Order::getDate));
//            case 2 -> orders.sort(Comparator.comparing(Order::getNewDate));
//            case 3 -> orders.sort(Comparator.comparing(Order::getTime));
//            case 4 -> orders.sort(Comparator.comparing(Order::getPrice));
//            default -> throw new IllegalStateException("Unexpected value: " + tmp);
//        }
        return orders;
    }

    @Override
    public void getOrderByMaster(int tmp) {
//        iAdminDao.showOrderByMaster(iMasterDao.getCurrentMaster(tmp));
    }

    @Override
    public List<String> getActiveOrdersByTimes(Date firstDate, Date lastDate) {
        List<Order> orders = null;
//        = iAdminDao.getOrders();
        List<String> newOrders = new ArrayList<>();

        orders.sort(Comparator.comparing(Order::getTime));

        for (Order order : orders)
            if (order.getDate().after(firstDate) && order.getNewDate().before(lastDate))
                if (order.getState().equals(State.ACTIVE_ORDER))
                    newOrders.add(order.toString());

        return newOrders;
    }

    @Override
    public List<String> getClosedOrdersByTimes(Date firstDate, Date lastDate) {
        List<Order> orders = null;
//        = iAdminDao.getOrders();
        List<String> newOrders = new ArrayList<>();

        orders.sort(Comparator.comparing(Order::getNewDate));

        for (Order order : orders)
            if (order.getDate().after(firstDate) && order.getNewDate().before(lastDate))
                if (order.getState().equals(State.CLOSED_ORDER))
                    newOrders.add(order.toString());

        return newOrders;
    }

    @Override
    public List<String> getCanceledOrdersByTimes(Date firstDate, Date lastDate) {
        List<Order> orders = null;
//        iAdminDao.getOrders();
        List<String> newOrders = new ArrayList<>();

        orders.sort(Comparator.comparing(Order::getPrice));

        for (Order order : orders)
            if (order.getDate().after(firstDate) && order.getNewDate().before(lastDate))
                if (order.getState().equals(State.CANCELLED_ORDER))
                    newOrders.add(order.toString());

        return newOrders;
    }

    @Override
    public void showNearestDate() {
        ArrayList<Order> orders = null;
//        iAdminDao.getOrders();
        Date controlDate = calendar.getTime();

        for (Order order : orders)
            if (order.getNewDate().after(controlDate))
                controlDate = order.getNewDate();

        System.out.println(controlDate);
    }
}
