package com.epam.training.toto.domain;

public class Hit {
    private int hitType;
    private int hits;
    private double price;
    public Hit(int hitType, int hits, double price) {
        this.hitType = hitType;
        this.hits = hits;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getHits() {
        return hits;
    }

    public int getHitType() {
        return hitType;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public void setHitType(int hitType) {
        this.hitType = hitType;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
