package com.juange.digitalorigin.app.model;

/**
 * Created by juange on 20/11/15.
 */
public class Mug extends Product {

    public static final double price = 7.5;

    @Override
    protected double productPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + "Mug";
    }
}
