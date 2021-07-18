package com.senla.autoservice.service;


import com.senla.autoservice.model.Master;

import java.util.ArrayList;
import java.util.List;

public interface IMasterService {
    void addMaster(String name, String position, int salary, int free);
    void dellMaster(String name);
    void getCurrentMaster(int tmp);

    ArrayList<Master> getMasters();
    void showMasters();

    List<Master> getAutoMasters();
    List<String> getNotFreeAutoMasters();

    void getMasterByOrder(int tmp);

}
