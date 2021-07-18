package com.senla.autoservice.view;

import com.senla.autoservice.view.actions.AdminActions.*;
import com.senla.autoservice.view.actions.MasterActions.AddMaster;
import com.senla.autoservice.view.actions.MasterActions.DeleteMaster;
import com.senla.autoservice.view.actions.MasterActions.GetCurrentMaster;
import com.senla.autoservice.view.actions.MasterActions.ShowMasters;
import com.senla.autoservice.view.actions.OrganizationActions.AddWorkplace;
import com.senla.autoservice.view.actions.OrganizationActions.ShowWorkplaces;
import com.senla.autoservice.composition.ApplicationContext;
import com.senla.autoservice.controller.realizations.OrganizationController;
import com.senla.autoservice.view.actions.AdminActions.*;
import com.senla.autoservice.view.actions.MasterActions.*;
import com.senla.autoservice.view.actions.OrganizationActions.*;

public class Builder {
    private Menu rootMenu;

    public void buildMenu(ApplicationContext applicationContext) throws ReflectiveOperationException {
        Menu adminController = new Menu();
        Menu masterController = new Menu();
        Menu organizationController = new Menu();

        rootMenu = new Menu();
        rootMenu.setName("Program's menu");
        rootMenu.setMenuItems(new MenuItem("Master's controller", null, masterController));

        masterController.setName("Master controller");
        masterController.setMenuItems(new MenuItem("add new master", new AddMaster(applicationContext), null));
        masterController.setMenuItems(new MenuItem("delete master", new DeleteMaster(applicationContext), null));
        masterController.setMenuItems(new MenuItem("get current master", new GetCurrentMaster(applicationContext), null));
        masterController.setMenuItems(new MenuItem("show masters", new ShowMasters(applicationContext), null));

        rootMenu.setMenuItems(new MenuItem("Admin controller", null, adminController));

        adminController.setName("Admin controller");
        adminController.setMenuItems(new MenuItem("add new order", new AddOrder(applicationContext), null));
        adminController.setMenuItems(new MenuItem("delete new order", new DeleteOrder(applicationContext), null));
        adminController.setMenuItems(new MenuItem("change order's time", new ChangeOrderTime(applicationContext), null));
        adminController.setMenuItems(new MenuItem("get last order", new GetLastOrder(applicationContext), null));
        adminController.setMenuItems(new MenuItem("show orders", new ShowOrders(applicationContext), null));

        rootMenu.setMenuItems(new MenuItem("Organization controller", null, organizationController));

        organizationController.setName("Organization controller");
        organizationController.setMenuItems(new MenuItem("add new workplace", new AddWorkplace(OrganizationController.getInstance()), null));
        organizationController.setMenuItems(new MenuItem("show workplaces", new ShowWorkplaces(OrganizationController.getInstance()), null));
    }

    public Menu getRootMenu() {
        return rootMenu;
    }
}
