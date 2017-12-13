package OrderApp;

import java.io.Serializable;
import java.util.List;

/**
 * Interface is serializable
 * The methode getOrderRegel get all the orderregels from the current order.
 * The Methode returns e List of orderRegels
 */
public interface IOrder  extends Serializable{
    List<OrderRegel> getOrderRegel();
}