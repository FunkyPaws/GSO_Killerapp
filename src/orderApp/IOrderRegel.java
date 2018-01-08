package orderApp;

import shared.Item;
import java.io.Serializable;

/**
 * Interface is serializable
 * Methode getItem get the item by the item name.
 * Each item has a unique name.
 * The methode returns a item that is the same a the item name that is given to the methode.
 * Methode getAmount gets the amount of the regel.
 * The methode returns nothing.
 */
public interface IOrderRegel extends Serializable {
    Item getItem(String itemName);
    Item getItem();
    Integer getAmount();
}
