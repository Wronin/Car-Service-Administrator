package com.senla.autoservice.view.actions.AdminActions;

import com.senla.autoservice.composition.ApplicationContext;
import com.senla.autoservice.controller.realizations.AdminController;
import com.senla.autoservice.view.IAction;

public class ShowOrders implements IAction {
    private final AdminController adminController;

    public ShowOrders (ApplicationContext applicationContext) throws ReflectiveOperationException {
        this.adminController = applicationContext.getObject(AdminController.class);
    }

    @Override
    public void execute() {
        adminController.getLastOrder();
    }
}
