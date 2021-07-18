package com.senla.autoservice.dao;

import com.senla.autoservice.model.Garage;

import java.util.ArrayList;

public interface IOrganizationDao {

    Garage getCurrentGarage(int tmp);
    ArrayList<Garage> getWorkplaces();
    void addWorkplace(Garage garage);
    void dellWorkplace(int tmp);
    void showListOfFreeSlots();
    void showWorkplace();

}
