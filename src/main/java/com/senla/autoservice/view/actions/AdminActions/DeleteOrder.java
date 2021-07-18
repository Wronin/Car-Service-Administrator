package com.senla.autoservice.view.actions.AdminActions;

import com.senla.autoservice.composition.ApplicationContext;
import com.senla.autoservice.controller.realizations.AdminController;
import com.senla.autoservice.view.IAction;

import java.util.Scanner;

public class DeleteOrder implements IAction {
    private final AdminController adminController;

    public DeleteOrder(ApplicationContext applicationContext) throws ReflectiveOperationException {
        this.adminController = applicationContext.getObject(AdminController.class);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        adminController.showOrders();
        adminController.deleteOrder(scanner.nextInt());
    }
}
