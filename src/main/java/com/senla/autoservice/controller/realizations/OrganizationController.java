package com.senla.autoservice.controller.realizations;

import com.senla.autoservice.controller.IOrganizationController;
import com.senla.autoservice.service.realizations.OrganizationService;

public class OrganizationController implements IOrganizationController {

    public static class OrganizationControllerSingl {
        public static final OrganizationController INSTANCE = new OrganizationController();
    }

    public static OrganizationController getInstance() {
        return OrganizationControllerSingl.INSTANCE;
    }

    @Override
    public void addWorkpalce(String address, int number) {
        OrganizationService.getInstance().addWorkplace(address, number);
    }

    @Override
    public void showWorkplaces() { OrganizationService.getInstance().showWorkplaces();}
}
