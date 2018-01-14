package orderApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shared.Item;
import shared.ItemCategory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Item frietM;
    Item saladeSide;
    Item saladeKip;
    Item frisK;
    Item frisM;
    Item danone;
    Item tomaat;

    OrderRegel orderRegel1;
    OrderRegel orderRegel2;
    OrderRegel orderRegel3;

    Order order1;
    Order order2;
    Order order3;

    List<OrderRegel> orderRegels;
    List<OrderRegel> orderRegels2;
    List<OrderRegel> orderRegels3;

    @BeforeEach
    void setUp() {
        frietM = new Item("medium friet", 1.75, ItemCategory.Fries);
        saladeSide = new Item("side salade", 1.25, ItemCategory.Salad);
        saladeKip = new Item("Ceasan salade met kip", 2.45, ItemCategory.Salad);
        frisK = new Item("kleine frisdrank", 1.25, ItemCategory.Drink);
        frisM = new Item("medium frisdrank", 1.90, ItemCategory.Drink);
        danone = new Item("danoontje", 0.90, ItemCategory.Other);
        tomaat = new Item("snoeptomaatjes", 0.90, ItemCategory.Other);

        orderRegels = new ArrayList<>();
        orderRegels2 = new ArrayList<>();
        orderRegels3 = new ArrayList<>();

        orderRegel1 = new OrderRegel(frietM, 2);
        orderRegel2 = new OrderRegel(saladeSide, 1);

        orderRegels.add(orderRegel1);
        orderRegels.add(orderRegel2);

        orderRegels2.add(orderRegel1);

        orderRegels3.add(orderRegel1);
        orderRegels3.add(orderRegel1);
        orderRegels3.add(orderRegel2);

        order1 = new Order();
        order2 = new Order();

        order2.addItem(frietM, 2);
        order2.addItem(saladeSide, 1);
        order2.addItem(frietM, 2);

    }

    @Test
    void getObserverListOrderregels() throws Exception {
        order1.addItem(frietM, 2);
        order1.addItem(saladeSide, 1);

        assertEquals(orderRegels.size(), order1.getObserverListOrderregels().size());
        assertNotEquals(orderRegels2.size(), order1.getObserverListOrderregels().size());
    }

    @Test
    void addItem() throws Exception {
        order1.addItem(saladeSide, 1);
        order1.addItem(frietM, 2);
        order1.addItem(frietM, 2);

        assertEquals(order1.getObserverListOrderregels(), order2.getObserverListOrderregels());
        assertEquals(order1.getObserverListOrderregels().size(), order2.getObserverListOrderregels().size());
    }

    @Test
    void removeItem() throws Exception {

    }

    @Test
    void getOrderRegel() throws Exception {
        order1.addItem(saladeSide, 1);
        order1.addItem(frietM, 2);
        order1.addItem(frietM, 2);
        assertEquals(order2.getOrderRegel(), order1.getOrderRegel());
        assertEquals(order2.getOrderRegel().size(), order1.getOrderRegel().size());
    }

    @Test
    void nextOrderNumber() throws Exception {
    }

    @Test
    void getTotalPrice() throws Exception {
    }

    @Test
    void removeAllItems() throws Exception {
    }

}