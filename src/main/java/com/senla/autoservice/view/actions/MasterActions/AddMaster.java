package com.senla.autoservice.view.actions.MasterActions;

import com.senla.autoservice.composition.ApplicationContext;
import com.senla.autoservice.controller.realizations.MasterController;
import com.senla.autoservice.view.IAction;

import java.util.Scanner;

public class AddMaster implements IAction {
    private final MasterController masterController;

    public AddMaster(ApplicationContext applicationContext) throws ReflectiveOperationException {
        masterController = applicationContext.getObject(MasterController.class);
    }


    @Override
    public void execute() {

        int salary, free;
        String name, pos;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write a name of master ");
        name = scanner.nextLine();
        System.out.println("Write a position of master ");
        pos = scanner.nextLine();
        System.out.println("Write a salary of master ");
        salary = scanner.nextInt();
        free = 1;

        masterController.addMaster(name, pos, salary, free);
    }
}
