package com.senla.autoservice.service;

import com.senla.autoservice.model.Garage;
import com.senla.autoservice.model.Order;
import com.senla.autoservice.model.*;

import java.util.Date;

public interface IOrganizationService {

    Garage getCurrentGarage(int tmp);
    void addWorkplace(String address, int number);
    void addWorkplace(String address, int number, Order order);
    void dellWorkplace(int tmp);
    void getListOfFreeSlots();
    void showWorkplaces();

    void getCountOfFreeWorkplaces(Date needDate);
}

