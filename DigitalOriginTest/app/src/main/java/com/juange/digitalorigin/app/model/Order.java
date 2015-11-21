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

        bill += calculateMugs();

        return bill;
    }

    private double calculateMugs() {
        return mugs.size() * Mug.price;
    }

    private double calculateStickers() {
        int stickerCount = stickers.size();
        double bill = 0.0;

        final int stickerElementsForDiscount = 5;
        final int elementsWithDiscount = stickerCount / stickerElementsForDiscount;
        final int elementsWithoutDiscount = stickerCount % stickerElementsForDiscount;
        bill += elementsWithDiscount * Sticker.price  * 3;

        if (elementsWithoutDiscount != 0 && stickerCount > 0) {
            bill += Sticker.price * elementsWithoutDiscount;
        }
        return bill;
    }

    private double calculateCaps() {
        int capCount = caps.size();
        double bill = 0.0;

        final int capElementsForDiscount = 2;
        final int elementsWithDiscount = capCount / capElementsForDiscount;
        final int elementsWithoutDiscount = capCount % capElementsForDiscount;
        bill += elementsWithDiscount * Cap.reducedPrice * capElementsForDiscount;

        if (elementsWithoutDiscount != 0 && capCount > 0) {
            bill += Cap.price * elementsWithoutDiscount;
        }
        return bill;
    }

    private double calculateTshirts() {
        int tshirtCount = tshirts.size();

        double bill = 0;

        if (tshirtCount >= 3) {
            bill += tshirtCount * Tshirt.reducedPrice;
        } else {
            bill += tshirtCount * Tshirt.price;
        }

        return bill;
    }
}
