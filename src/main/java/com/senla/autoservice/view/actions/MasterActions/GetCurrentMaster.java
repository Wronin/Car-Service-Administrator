package com.senla.autoservice.view.actions.MasterActions;

import com.senla.autoservice.composition.ApplicationContext;
import com.senla.autoservice.controller.realizations.MasterController;
import com.senla.autoservice.view.IAction;

import java.util.Scanner;

public class GetCurrentMaster implements IAction {
    private final MasterController masterController;


    public GetCurrentMaster(ApplicationContext applicationContext) throws ReflectiveOperationException {
        this.masterController = applicationContext.getObject(MasterController.class);
    }

    @Override
    public void execute() {

        Scanner in = new Scanner(System.in);
        System.out.println("getting a current master");
        masterController.getCurrentMaster(in.nextInt());
    }
}
