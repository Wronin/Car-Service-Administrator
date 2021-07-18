package com.senla.autoservice.view.actions.MasterActions;

import com.senla.autoservice.composition.ApplicationContext;
import com.senla.autoservice.controller.realizations.MasterController;
import com.senla.autoservice.view.IAction;

public class ShowMasters implements IAction {
    private final MasterController masterController;


    public ShowMasters(ApplicationContext applicationContext) throws ReflectiveOperationException {
        this.masterController = applicationContext.getObject(MasterController.class);
    }

    @Override
    public void execute() {
        masterController.showMasters();
    }
}
