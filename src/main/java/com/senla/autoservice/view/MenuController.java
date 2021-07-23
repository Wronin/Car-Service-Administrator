package com.senla.autoservice.view;

import com.senla.autoservice.composition.annotations.ConfigProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class MenuController {
    private Builder builder;
    private Navigator navigator;


    private static final Logger logger = LogManager.getLogger(MenuController.class.getName());

    public MenuController(Builder builder, Navigator navigator) {
        this.builder = builder;
        this.navigator = navigator;
    }

    public void run() {
        int input = 0;

        while (true) {
            navigator.printMenu();
            logger.info("printed menu");

            try {
                Scanner in = new Scanner(System.in);

                input = in.nextInt();
                logger.info("User input: " + input);
                if (input == 0) {
//                    SerializationController.getInstance().writeObject(iMasterDao.getMasters(), "MasterDao");
                    break;
                } else if (input == 10)
                    navigator.setCurrentMenu(builder.getRootMenu());

                navigator.navigate(input);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }

        }
    }
}
