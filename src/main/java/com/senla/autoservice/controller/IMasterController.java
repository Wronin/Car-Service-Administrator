package com.senla.autoservice.controller;

public interface IMasterController {

    void addMaster(String name, String pos, int salary, int free);
    void deleteMaster(String name);
    void getCurrentMaster(int tmp);
    void showMasters();

}
