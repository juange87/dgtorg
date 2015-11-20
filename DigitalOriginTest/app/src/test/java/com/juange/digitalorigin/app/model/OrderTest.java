package com.juange.digitalorigin.app.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by juange on 20/11/15.
 */
public class OrderTest {

    @Test
    public void test1() throws Exception {
        Order order = new Order();

        order.addProduct(new Cap());
        order.addProduct(new Tshirt());
        order.addProduct(new Mug());

        final double expected = 52.5;
        final double reducedBill = order.getReducedBill();

        System.out.println("TEST 1");
        System.out.println("Expected: " + expected);
        System.out.println("Get: " + reducedBill);
        System.out.println();

        assertEquals(expected, reducedBill, 0.1);
    }

    @Test
    public void test2() throws Exception {
        Order order = new Order();

        order.addProduct(new Cap());
        order.addProduct(new Tshirt());
        order.addProduct(new Cap());

        final double expected = 45;
        final double reducedBill = order.getReducedBill();

        System.out.println("TEST 2");
        System.out.println("Expected: " + expected);
        System.out.println("Get: " + reducedBill);
        System.out.println();

        assertEquals(expected, reducedBill, 0.1);
    }

    @Test
    public void test3() throws Exception {
        Order order = new Order();

        order.addProduct(new Cap());
        order.addProduct(new Tshirt());
        order.addProduct(new Cap());
        order.addProduct(new Sticker());
        order.addProduct(new Sticker());
        order.addProduct(new Sticker());
        order.addProduct(new Sticker());
        order.addProduct(new Sticker());

        final double expected = 48;
        final double reducedBill = order.getReducedBill();

        System.out.println("TEST 3");
        System.out.println("Expected: " + expected);
        System.out.println("Get: " + reducedBill);
        System.out.println();

        assertEquals(expected, reducedBill, 0.1);
    }

    @Test
    public void test4() throws Exception {
        Order order = new Order();

        order.addProduct(new Tshirt());
        order.addProduct(new Tshirt());
        order.addProduct(new Tshirt());
        order.addProduct(new Cap());
        order.addProduct(new Sticker());

        final double expected = 91;
        final double reducedBill = order.getReducedBill();

        System.out.println("TEST 4");
        System.out.println("Expected: " + expected);
        System.out.println("Get: " + reducedBill);
        System.out.println();

        assertEquals(expected, reducedBill, 0.1);
    }

    @Test
    public void test5() throws Exception {
        Order order = new Order();

        order.addProduct(new Cap());
        order.addProduct(new Tshirt());
        order.addProduct(new Cap());
        order.addProduct(new Cap());
        order.addProduct(new Mug());
        order.addProduct(new Tshirt());
        order.addProduct(new Tshirt());

        final double expected = 94.5;
        final double reducedBill = order.getReducedBill();

        System.out.println("TEST 5");
        System.out.println("Expected: " + expected);
        System.out.println("Get: " + reducedBill);
        System.out.println();

        assertEquals(expected, reducedBill, 0.1);
    }
}