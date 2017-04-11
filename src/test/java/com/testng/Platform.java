package com.testng;

/**
 * Created by November on 29.03.2017.
 */
public enum Platform {

    WIN("Windows"),
    LINUX("Linux"),
    ALL("All");

    private String name;

    Platform(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
