package com.juange.digitalorigin.app.model;

/**
 * Created by juange on 20/11/15.
 */
public class Cap extends Product {

    public static final double price = 15;
    public static final double reducedPrice = 5.5;

    @Override
    protected double productPrice() {
        return 15;
    }

    @Override
    public String toString() {
        return super.toString() + "Cap";
    }
}
