package com.spring.mongo.demo.model;

public class Deal {
    private String date;
    private int price;

    public Deal(String date, int price) {
        this.date = date;
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "date='" + date + '\'' +
                ", price=" + price +
                '}';
    }
}
