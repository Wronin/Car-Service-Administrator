package com.senla.autoservice.service.realizations;

import com.senla.autoservice.dao.IMasterDao;
import com.senla.autoservice.composition.annotations.InjectByClassType;
import com.senla.autoservice.composition.annotations.Singleton;
import com.senla.autoservice.dao.realizations.*;
import com.senla.autoservice.model.Master;
import com.senla.autoservice.service.IMasterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class MasterService implements IMasterService {

    private static final Logger logger = LogManager.getLogger(MasterService.class);

    @InjectByClassType
    private IMasterDao iMasterDao;

    @Override
    public void addMaster(String name, String position, int salary, int free) {
        try {
            Master master = new Master(name, position, salary, free);
            Master master1 = new Master(name, "lastName", 88888888, "address", "position", salary, free);
            iMasterDao.addMaster(master1);
            logger.info("added master " + master.toString());
        } catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public void dellMaster(String name) {
        try {
            iMasterDao.dellMaster(name);
            logger.info("deleted master " + name);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void getCurrentMaster(int tmp) {
        try {
            logger.info("returned current master " + iMasterDao.getCurrentMaster(tmp));
            iMasterDao.getCurrentMaster(tmp);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void showMasters() {
        try {
            logger.info("output of all masters");
            iMasterDao.showMasters();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public ArrayList<Master> getMasters() {
//        return iMasterDao.getMasters();
        return new ArrayList<>();
    }

    @Override
    public List<Master> getAutoMasters() {
//        List<Master> masters = iMasterDao.getMasters();
//        masters.sort(Comparator.comparing(Master::getName));
//        return masters;
        return new ArrayList<>();
    }

    @Override
    public List<String> getNotFreeAutoMasters() {
//        List<Order> orders = iAdminDao.getOrders();
        List<String> masters = new ArrayList<>();
//
//        for (Order order : orders)
//            if (!order.getState().equals(State.CREATED)) {
//                masters.add(order.getMaster().getName());
//            }

        return masters;
    }

    @Override
    public void getMasterByOrder(int tmp) {
//        iMasterDao.showMasterByOrder(iAdminDao.getCurrentOrder(tmp));
    }
}
