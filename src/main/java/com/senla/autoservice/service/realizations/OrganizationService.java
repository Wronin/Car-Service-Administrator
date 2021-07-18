package com.senla.autoservice.service.realizations;

import com.senla.autoservice.composition.annotations.ConfigProperty;
import com.senla.autoservice.dao.realizations.OrganizationDao;
import com.senla.autoservice.model.Garage;
import com.senla.autoservice.model.Order;
import com.senla.autoservice.model.*;
import com.senla.autoservice.service.IOrganizationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public class OrganizationService implements IOrganizationService {

    private static final Logger logger = LogManager.getLogger(MasterService.class);

    public static class IOrganizationServiceSingle {
        public static final IOrganizationService INSTANCE = new OrganizationService();
    }

    public static IOrganizationService getInstance() {
        return IOrganizationServiceSingle.INSTANCE;
    }

    @ConfigProperty(PropertyName = "OrganizationService.canChangeCountOfGarages", classType = Integer.class)
    Integer canChangeCountOfGarages;

    @Override
    public Garage getCurrentGarage(int tmp) {
//        return iOrganizationDao.getCurrentGarage(tmp);
        return new Garage();
    }

    @Override
    public void addWorkplace(String address, int number) {
        try {
            if (canChangeCountOfGarages == 1) {
                Order order = new Order();
                OrganizationDao.getInstance().addWorkplace(new Garage(address, number, order));
                logger.info("added new workplace");
            }
        } catch (Exception msg) {
            logger.error("");
        }
    }

    @Override
    public void addWorkplace(String address, int number, Order order) {
//        iOrganizationDao.addWorkplace(new Garage(address, number, order));
    }

    @Override
    public void dellWorkplace(int tmp) {
//        iOrganizationDao.dellWorkplace(tmp);
    }

    @Override
    public void getListOfFreeSlots() {
//        iOrganizationDao.showListOfFreeSlots();
    }

    @Override
    public void showWorkplaces() {
        OrganizationDao.getInstance().showWorkplace();
    }

    @Override
    public void getCountOfFreeWorkplaces(Date needDate) {
//        ArrayList<Garage> workplaces = iOrganizationDao.getWorkplaces();
//        List<String> masters = new ArrayList<>();
//
//        for (Garage workplace : workplaces)
//            if (!workplace.getOrder().getState().equals(State.CREATED))
//                if (workplace.getOrder().getDate().before(needDate) && workplace.getOrder().getNewDate().after(needDate))
//                    masters.add(workplace.getOrder().getMaster().getName());
//
//        System.out.println(iMasterDao.getMasters().size() - masters.size());
    }
}
