package com.senla.autoservice.view;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String name;
    private List<MenuItem> menuItems;

    public Menu() {
        menuItems = new ArrayList<>();
    }

    public String getName() { return name; }

    public List<MenuItem> getMenuItems() {
        return new ArrayList<>(menuItems);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMenuItems(MenuItem menuItem) {
        menuItems.add(menuItem);
    }
}
