package com.juange.digitalorigin.app.model;

/**
 * Created by juange on 20/11/15.
 */
public class Tshirt extends Product {

    public static final double price = 30;
    public static final double reducedPrice = 19;

    @Override
    protected double productPrice() {
        return price;
    }


    @Override
    public String toString() {
        return super.toString() + "T-shirt";
    }
}
