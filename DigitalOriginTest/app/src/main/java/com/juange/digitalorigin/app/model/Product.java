package com.juange.digitalorigin.app.model;

/**
 * Created by juange on 20/11/15.
 */
public abstract class Product {

    private double price;

    protected abstract double productPrice();

    @Override
    public String toString() {
        return "Product";
    }

    public double getPrice() {
        return productPrice();
    }
}
