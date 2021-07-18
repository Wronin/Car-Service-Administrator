package com.senla.autoservice.dao;

import com.senla.autoservice.model.Master;
import com.senla.autoservice.model.Order;

import java.util.ArrayList;

public interface IMasterDao {
    void addMaster(Master master);
    void dellMaster(String name);
    Master getCurrentMaster(int tmp);
    ArrayList<Master> getMasters();
    void showMasters();
    void showMasterByOrder(Order order);
}
