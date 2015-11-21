package com.juange.digitalorigin.app.model;

/**
 * Created by juange on 20/11/15.
 */
public class Sticker extends Product {

    public static final double price = 1;

    @Override
    protected double productPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + "Sticker";
    }
}
