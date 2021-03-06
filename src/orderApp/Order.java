package orderApp;

import shared.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Integer orderNumber = 0;
    private Double totalPrice;

    private ObservableList<OrderRegel> observerListOrderregels;
    private List<OrderRegel> orderRegels;

    public Order() {
        this.totalPrice = 0.0;
        orderRegels = new ArrayList<>();
        observerListOrderregels = FXCollections.observableList(orderRegels);
    }

    public ObservableList<OrderRegel> getObserverListOrderregels() {
        return observerListOrderregels;
    }

    public void addItem(Item item, int amount) {
        int j = 0;
        OrderRegel orderRegel = new OrderRegel(item, amount);

        if (observerListOrderregels.contains(orderRegel)) {
            for (int i = 0; i < observerListOrderregels.size(); i++) {
                OrderRegel regel = observerListOrderregels.get(i);
                if (orderRegel.equals(regel)) {
                    j = regel.getAmount();
                    observerListOrderregels.remove(regel);

                    int k = orderRegel.getAmount();
                    k += j;
                    orderRegel.setAmount(k);
                    observerListOrderregels.add(orderRegel);
                    break;
                }
            }
        } else {
            observerListOrderregels.add(orderRegel);
        }
    }

    public List<OrderRegel> getOrderRegel() {
        return orderRegels;
    }

    public int nextOrderNumber() {
        if(orderNumber >= 99){
            orderNumber = 0;
        }
        else if (orderNumber < 99) {
            orderNumber++;
        }
        return orderNumber;
    }

    public Double getTotalPrice() {
        totalPrice = 0.0;
        for (OrderRegel orderregel : orderRegels) {
            totalPrice += orderregel.getItem().getPrice() * orderregel.getAmount();
        }
        return totalPrice;
    }

    public void removeAllItems() {
        for (int i = 0; i < orderRegels.size(); ) {
            OrderRegel orderRegel = orderRegels.get(i);

            if (!orderRegels.remove(orderRegel)) {
                i++;
            }
        }
    }
}