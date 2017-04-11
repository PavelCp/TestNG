package com.testng;

/**
 * Created by November on 29.03.2017.
 */
public enum DriverType {

    ALL("All"),
    CHROME("Chrome"),
    EDGE("Edge"),
    FIREFOX("Firefox"),
    IE("IE"),
    MARIONETTE("Marionette"),
    REMOTE("Remote"),
    SAFARI("Safari");

    private String name;

    DriverType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
