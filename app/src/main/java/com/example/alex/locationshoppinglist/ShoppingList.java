package com.example.alex.locationshoppinglist;

/**
 * Created by Alex on 8/19/17.
 */

public class ShoppingList {

    private String name;
    private String location;

    public ShoppingList() {
        name = "";
        location = "";
    }

    public ShoppingList(String name) {
        this.name = name;
        location = "";
    }

    public ShoppingList(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
