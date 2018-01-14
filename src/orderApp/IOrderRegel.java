package orderApp;

import shared.Item;
import java.io.Serializable;

public interface IOrderRegel extends Serializable {
    /**
     * get the item
     * @return a items and its props
     */
    Item getItem();

    /**
     * get the amount of orderregels
     * @return integer van amount
     */
    Integer getAmount();
}
