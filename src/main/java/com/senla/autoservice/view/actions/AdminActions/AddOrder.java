package com.senla.autoservice.view.actions.AdminActions;

import com.senla.autoservice.composition.ApplicationContext;
import com.senla.autoservice.controller.realizations.AdminController;
import com.senla.autoservice.model.Client;
import com.senla.autoservice.model.Master;
import com.senla.autoservice.model.State;
import com.senla.autoservice.view.IAction;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class AddOrder implements IAction {
    private final AdminController adminController;

    public AddOrder(ApplicationContext applicationContext) throws ReflectiveOperationException {
        this.adminController = applicationContext.getObject(AdminController.class);
    }

    @Override
    public void execute() {
        Calendar calendar = new GregorianCalendar();
        Date time = calendar.getTime();
        String name, problem;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write client's name ");
        name = scanner.nextLine();
        System.out.println("Write client's problem ");
        problem = scanner.nextLine();

        adminController.addOrder(new Client(name, problem), time, adminController.getLastOrder().getNewDate(), null, State.ACTIVE_ORDER, new Master("test name", "test pos", 1, 1), 1000);
    }
}
