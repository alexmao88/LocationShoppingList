package com.example.alex.locationshoppinglist;

/**
 * Created by Alex on 8/19/17.
 */

public class Item {

    private String name;
    private String location;

    public Item() {
        name = "";
        location = "";
    }

    public Item(String name) {
        this.name = name;
        location = "";
    }

    public Item(String name, String location) {
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
