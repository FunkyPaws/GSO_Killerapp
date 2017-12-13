package OrderApp;

import Shared.Item;
import java.util.ArrayList;
import java.util.List;

public class Order implements IOrder {

    private Integer orderNumber;
    private Double totalPrice;
    private Boolean orderStatus;

    private List<OrderRegel> orderRegels;

    public Order(Integer orderNumber, Double totalPrice, Boolean orderStatus) {
        this.orderNumber = orderNumber;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        orderRegels = new ArrayList<>();
    }

    public Order(Integer orderNumber, Boolean orderStatus) {
        this.orderNumber = orderNumber;
        this.totalPrice = 0.0;
        this.orderStatus = orderStatus;
        orderRegels = new ArrayList<>();
    }


    public void addItem(Item item, int amount) {
        OrderRegel regel = new OrderRegel(item, amount);
        orderRegels.add(regel);
    }

    public void removeItem(Item item, int amount) {
        orderRegels.remove(item);
        //TODO test if this is the right methode to do so.
    }

    @Override
    public List<OrderRegel> getOrderRegel() {
        //TODO fill in methode.
        return null;
    }

    public void nextOrderNumber() {
        //TODO fill in methode.
    }

    public void changeOrderStatus() {
        if (orderStatus == true) {
            orderStatus = false;
        } else if (orderStatus == false) {
            orderStatus = true;
        }
    }
}
