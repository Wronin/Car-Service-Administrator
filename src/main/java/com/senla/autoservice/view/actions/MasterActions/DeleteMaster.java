package com.senla.autoservice.view.actions.MasterActions;

import com.senla.autoservice.composition.ApplicationContext;
import com.senla.autoservice.controller.realizations.MasterController;
import com.senla.autoservice.view.IAction;

import java.util.Scanner;

public class DeleteMaster implements IAction {
    private final MasterController masterController;

    public DeleteMaster(ApplicationContext applicationContext) throws ReflectiveOperationException {
        masterController = applicationContext.getObject(MasterController.class);
    }

    @Override
    public void execute() {

        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        masterController.deleteMaster(name);
    }
}
