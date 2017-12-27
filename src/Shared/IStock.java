package Shared;

import java.rmi.Remote;

/**
 * Interface is serializable.
 * Methode getItemName gets the name of a item.
 * The methode returns a string.
 * Methode getAmount gets the amount of the amount of items.
 * The methode returns a integer.
 */
public interface IStock   {
    String getItemName();
    Integer getAmount();

}
