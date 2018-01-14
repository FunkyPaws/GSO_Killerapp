package orderApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shared.Item;
import shared.ItemCategory;
import static org.junit.jupiter.api.Assertions.*;

class OrderRegelTest {

    Item hamburger;
    Item cheesburger;
    Item frietK;

    int number;
    int number2;

    OrderRegel orderRegel1;
    OrderRegel orderRegel2;
    OrderRegel orderRegel3;

    @BeforeEach
    void setUp() {
        hamburger = new Item("hamburger", 1.20, ItemCategory.Burger);
        cheesburger = new Item("cheesburger", 1.50, ItemCategory.Burger);
        frietK = new Item("kleine friet", 1.00, ItemCategory.Fries);

        orderRegel1 = new OrderRegel(hamburger, 10);
        orderRegel2 = new OrderRegel(frietK, 1);
        orderRegel3 = new OrderRegel(frietK, 2);

        number = 10;
        number2 = 2;

    }

    @Test
    void getItem()throws Exception{
        assertEquals(hamburger, orderRegel1.getItem());
        assertNotEquals(cheesburger, orderRegel1.getItem());
    }


    @Test
    void getAmount() throws Exception{
        assertEquals(java.util.Optional.ofNullable(number), java.util.Optional.ofNullable(orderRegel1.getAmount()));
    }

    @Test
    void setAmount() throws Exception{
        orderRegel2.setAmount(number2);
        assertTrue(orderRegel3.equals(orderRegel2));
    }

    @Test
    void equals()throws Exception {
    }
}