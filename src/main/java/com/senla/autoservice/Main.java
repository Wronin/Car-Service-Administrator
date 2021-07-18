package com.senla.autoservice;

import com.senla.autoservice.composition.Application;
import com.senla.autoservice.composition.ApplicationContext;
import com.senla.autoservice.view.Builder;
import com.senla.autoservice.view.MenuController;
import com.senla.autoservice.view.Navigator;

import java.util.HashMap;


public class Main {

    public static void main(String[] args) throws ReflectiveOperationException {

        ApplicationContext applicationContext = Application.run("com.senla.autoservice", new HashMap<>());


        Builder builder = new Builder();
        builder.buildMenu(applicationContext);
        Navigator navigator = new Navigator(builder.getRootMenu());
        MenuController menuController = new MenuController(builder, navigator);

        menuController.run();
    }

}
