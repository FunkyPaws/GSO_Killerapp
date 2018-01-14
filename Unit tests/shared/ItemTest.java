package shared;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    Item saladeKip;
    Item frisK;
    Item frisM;
    Item danone;
    Item tomaat;
    Item tomaat2;

    String name;
    Double price;

    @BeforeEach
    void setUp() {
        saladeKip = new Item("Ceasan salade met kip", 2.45, ItemCategory.Salad);
        frisK = new Item("kleine frisdrank", 1.25, ItemCategory.Drink);
        frisM = new Item("medium frisdrank", 1.90, ItemCategory.Drink);
        danone = new Item("danoontje", 0.90, ItemCategory.Other);
        tomaat = new Item("snoeptomaatjes", 0.90, ItemCategory.Other);
        tomaat2 = new Item("snoeptomaatjes", 0.90, ItemCategory.Other);

        name = "Ceasan salade met kip";
        price = 0.90;
    }

    @Test
    void getName() {
        assertEquals(name, saladeKip.getName());
        assertNotEquals(name, frisK.getName());

    }

    @Test
    void getPrice() {
        assertEquals(price, danone.getPrice());
        assertNotEquals(price, frisM.getPrice());
    }

    @Test
    void equals() {
        assertTrue(tomaat.equals(tomaat2));
        assertFalse(tomaat.equals(saladeKip));
    }

}