package com.senla.autoservice.view.actions.OrganizationActions;

import com.senla.autoservice.controller.realizations.OrganizationController;
import com.senla.autoservice.view.IAction;

public class ShowWorkplaces implements IAction {
    private final OrganizationController organizationController;

    public ShowWorkplaces(OrganizationController organizationController) {
        this.organizationController = organizationController;
    }

    @Override
    public void execute() {
        OrganizationController.getInstance().showWorkplaces();
    }
}
