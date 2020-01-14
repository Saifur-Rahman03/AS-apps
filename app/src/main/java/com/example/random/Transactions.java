package com.example.random;

public class Transactions {
    public String description;
    public double cost;
    public double left;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Transactions(String description, double cost){
        this.description = description;
        this.cost = cost;
    }
}
