package com.senla.autoservice.dao.realizations;

import com.senla.autoservice.dao.IOrganizationDao;
import com.senla.autoservice.model.Garage;
import com.senla.autoservice.model.*;

import java.util.ArrayList;

public class OrganizationDao implements IOrganizationDao {

    public static class OrganizationDaoSingle {
        public static final IOrganizationDao INSTANCE = new OrganizationDao();
    }

    public static IOrganizationDao getInstance(){
        return OrganizationDaoSingle.INSTANCE;
    }

    private ArrayList<Garage> workplaces = new ArrayList<Garage>();

    @Override
    public Garage getCurrentGarage(int tmp) {
        return workplaces.get(tmp);
    }

    @Override
    public ArrayList<Garage> getWorkplaces() {
        return workplaces;
    }

    @Override
    public void addWorkplace(Garage garage) {
        workplaces.add(garage);
    }

    @Override
    public void dellWorkplace(int tmp) {
        workplaces.remove(tmp);
    }

    @Override
    public void showListOfFreeSlots() {
        int i = 0;
        System.out.println("Список свободных гаражей ");
        for (Garage workplace : workplaces)
            if (workplace.getOrder().getMaster() == null)
                System.out.println(i++
                        + ". " + workplace.getAddress()
                        + " " + workplace.getNumberPlace()
                );

        System.out.println("Список занятых гаражей");
        i = 0;
        for (Garage workplace : workplaces)
            if (workplace.getOrder().getMaster() != null)
                System.out.println(i++
                        + ". " + workplace.getAddress()
                        + " " + workplace.getNumberPlace()
                );
    }

    @Override
    public void showWorkplace() {
        int i = 0;
        System.out.println("Список всех гаражей ");
        for (Garage workplace : workplaces)
            System.out.println(i++
                    + ". " + workplace.getAddress()
                    + " " + workplace.getNumberPlace()
                    /*+ " " + workplace.getOrder().getProblem()
                    + " " + workplace.getOrder().getMaster().getName()*/);
    }


}
