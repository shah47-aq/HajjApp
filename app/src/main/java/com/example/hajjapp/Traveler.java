package com.example.hajjapp;

public class Traveler {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    private String pass;

    public Traveler(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }
}
