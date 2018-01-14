package shared;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    Item saladeKip;
    Item frisK;
    Item frisM;
    Item danone;
    Item tomaat;
    Item tomaat2;

    Stock stock1;
    Stock stock2;
    Stock stock3;

    @BeforeEach
    void setUp() {
        saladeKip = new Item("Ceasan salade met kip", 2.45, ItemCategory.Salad);
        frisK = new Item("kleine frisdrank", 1.25, ItemCategory.Drink);
        frisM = new Item("medium frisdrank", 1.90, ItemCategory.Drink);
        danone = new Item("danoontje", 0.90, ItemCategory.Other);
        tomaat = new Item("snoeptomaatjes", 0.90, ItemCategory.Other);
        tomaat2 = new Item("snoeptomaatjes", 0.90, ItemCategory.Other);

        stock1 = new Stock(saladeKip, 100);
        stock2 = new Stock(tomaat, 10);
        stock3 = new Stock(tomaat2, 100);
    }

    @Test
    void setAmount() {
        stock2.setAmount(100);
        assertSame(stock3.getAmount(), stock2.getAmount());
    }

    @Test
    void getItemName() {
        assertEquals(saladeKip.getName(), stock1.getItemName());
        assertNotEquals(frisK.getName(), stock1.getItemName());
    }

    @Test
    void getAmount() {
        int number = 100;

        assertSame(number, stock1.getAmount());
        assertNotSame(number, stock2.getAmount());
    }

    @Test
    void equals() {
        assertTrue(stock2.equals(stock3));
        assertFalse(stock1.equals(stock2));
    }
}