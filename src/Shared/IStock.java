package Shared;

import java.io.Serializable;

/**
 * Interface is serializable.
 * Methode getItemName gets the name of a item.
 * The methode returns a string.
 * Methode getAmount gets the amount of the amount of items.
 * The methode returns a integer.
 */
public interface IStock extends Serializable {
    String getItemName();
    Integer getAmount();

}
