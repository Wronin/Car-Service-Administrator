package com.senla.autoservice.dao.realizations;

import com.senla.autoservice.dao.IMasterDao;
import com.senla.autoservice.composition.annotations.Singleton;
import com.senla.autoservice.model.Master;
import com.senla.autoservice.model.Order;
import com.senla.autoservice.view.SerializationController;

import java.util.ArrayList;

@Singleton
public class MasterDao implements IMasterDao {

    private ArrayList<Master> masters;

    public MasterDao() {
        try {
            masters = SerializationController.getInstance().readObject(Master.class, "MasterDao");
        } catch (Exception msg) {
            masters = new ArrayList<>();
        }
    }

    @Override
    public void addMaster(Master master) {
        masters.add(master);
    }

    @Override
    public void dellMaster(String name) {
        masters.removeIf(master -> master.getName().equals(name));
    }

    @Override
    public Master getCurrentMaster(int tmp) {
        return masters.get(tmp);
    }

    @Override
    public ArrayList<Master> getMasters() {
        return masters;
    }

    @Override
    public void showMasters() {
        int i = 0;
        System.out.println("Список мастеров");
        for (Master master : masters)
            System.out.println(i++ + ". " + master.getName() + " " + master.getPosition() + " " + master.getSalary());
    }

    @Override
    public void showMasterByOrder(Order order) {
        if (order.getMaster().getName() != null)
            System.out.println(order.getMaster().toString());
    }

}
