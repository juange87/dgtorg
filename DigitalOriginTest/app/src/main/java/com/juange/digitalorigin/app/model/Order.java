package com.juange.digitalorigin.app.model;

import java.util.ArrayList;

/**
 * Created by juange on 20/11/15.
 */
public class Order {

    ArrayList<Product> products = new ArrayList<>();

    ArrayList<Cap> caps = new ArrayList<>();
    ArrayList<Tshirt> tshirts = new ArrayList<>();
    ArrayList<Mug> mugs = new ArrayList<>();
    ArrayList<Sticker> stickers = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);

        if (product instanceof Cap) {
            caps.add((Cap) product);
        } else if (product instanceof Tshirt) {
            tshirts.add((Tshirt) product);
        } else if (product instanceof Mug) {
            mugs.add((Mug) product);
        } else if (product instanceof Sticker) {
            stickers.add((Sticker) product);
        }
    }

    public double getBill() {
        double bill = 0;

        for (Product product : products) {
            bill += product.productPrice();
        }

        return bill;
    }

    public double getReducedBill() {
        double bill = 0;

        bill += calculateTshirts();

        bill += calculateCaps();

        bill += calculateStickers();

        bill += mugs.size() * Mug.price;

        return bill;
    }

    private double calculateStickers() {
        int stickerCount = stickers.size();
        double bill = 0.0;

        final int i2 = stickerCount / 5;
        final int i3 = stickerCount % 5;
        bill += i2 * (Sticker.price / 3.0) * 5;

        if (i3 != 0 && stickerCount > 0) {
            bill += Sticker.price * i3;
        }
        return bill;
    }

    private double calculateCaps() {
        int capCount = caps.size();
        double bill = 0.0;

        final int capElementsForDiscount = 2;
        final int i = capCount / capElementsForDiscount;
        final int i1 = capCount % capElementsForDiscount;
        bill += i * (Cap.price / 2.0) * capElementsForDiscount;

        if (i1 != 0 && capCount > 0) {
            bill += Cap.price * i1;
        }
        return bill;
    }

    private double calculateTshirts() {
       int tshirtCount = tshirts.size();

        double bill = 0;

        final int i0 = tshirtCount / 3;
        final int i00 = tshirtCount % 3;
        bill += i0 * (Tshirt.reducedPrice) * 3;

        if (i00 != 0 && tshirtCount > 0) {
            bill += Tshirt.price * i00;
        }
        return bill;
    }
}
