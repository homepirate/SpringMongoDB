package com.spring.mongo.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "home")

public class Home {
    @Id
    private String id;
    private String type;
    private String city;
    private int square;

    private Owner owner;
    private int index;
    private Deal deal;

    public Home(String id, String type, String city, int square, Owner owner, int index, Deal deal) {
        this.id = id;
        this.type = type;
        this.city = city;
        this.square = square;
        this.owner = owner;
        this.index = index;
        this.deal = deal;
    }

    public Home(String type, String city, int square, Owner owner, int index, Deal deal) {
        this.type = type;
        this.city = city;
        this.square = square;
        this.owner = owner;
        this.index = index;
        this.deal = deal;
    }

    public Home() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    @Override
    public String toString() {
        return "Home{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", city='" + city + '\'' +
                ", square=" + square +
                ", owner=" + owner +
                ", index=" + index +
                ", deal=" + deal +
                '}';
    }
}
