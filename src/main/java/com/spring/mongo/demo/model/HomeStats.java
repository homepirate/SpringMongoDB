package com.spring.mongo.demo.model;

public class HomeStats {
    private String _id;
    private double totalSquare;
    private int count;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public double getTotalSquare() {
        return totalSquare;
    }

    public void setTotalSquare(double totalSquare) {
        this.totalSquare = totalSquare;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "HomeStats{" +
                "type='" + _id + '\'' +
                ", totalSquare=" + totalSquare +
                ", count=" + count +
                '}';
    }
}