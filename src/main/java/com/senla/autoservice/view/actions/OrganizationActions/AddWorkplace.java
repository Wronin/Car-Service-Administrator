package com.senla.autoservice.view.actions.OrganizationActions;

import com.senla.autoservice.controller.realizations.OrganizationController;
import com.senla.autoservice.view.IAction;

import java.util.Scanner;

public class AddWorkplace implements IAction {
    private final OrganizationController organizationController;

    public AddWorkplace(OrganizationController organizationController) {
        this.organizationController = organizationController;
    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        int number;
        String address;

        System.out.println("Write address ");
        address = scanner.nextLine();
        System.out.println("Write number ");
        number = scanner.nextInt();

        OrganizationController.getInstance().addWorkpalce(address, number);
    }
}
