package com.example.hajjapp;

public class Packages {
    private String id;
    private String days;
    private String daysInMakkah;

    public Packages(String id, String days, String daysInMakkah, String daysInMadinah, String startDate, String endDate, String type, String price, String transport, String food) {
        this.id = id;
        this.days = days;
        this.daysInMakkah = daysInMakkah;
        this.daysInMadinah = daysInMadinah;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.price = price;
        this.transport = transport;
        this.food = food;
    }

    private String daysInMadinah;
    private String startDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getDaysInMakkah() {
        return daysInMakkah;
    }

    public void setDaysInMakkah(String daysInMakkah) {
        this.daysInMakkah = daysInMakkah;
    }

    public String getDaysInMadinah() {
        return daysInMadinah;
    }

    public void setDaysInMadinah(String daysInMadinah) {
        this.daysInMadinah = daysInMadinah;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    private String endDate;
    private String type;
    private String price;
    private String transport;
    private String food;
}
