package com.senla.autoservice.view;

import java.util.List;

public class Navigator {
    private Menu currentMenu;

    public Navigator(Menu menu) {
        currentMenu = menu;
    }

    public void printMenu() {
        System.out.println(currentMenu.getName());
        for (MenuItem menuItem : currentMenu.getMenuItems())
            System.out.println(menuItem.getTitle());

    }

    public void navigate(int index) {
        List<MenuItem> menuItems = currentMenu.getMenuItems();

        if (index <= menuItems.size()) {
            if (menuItems.get(index - 1).getAction() == null)
                currentMenu = menuItems.get(index - 1).getNextMenu();
            else
                menuItems.get(index - 1).doAction();
        } else {
            System.out.println("cant find current menu");
        }
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }
}
