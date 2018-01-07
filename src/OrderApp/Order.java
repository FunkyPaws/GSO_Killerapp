package OrderApp;

import Shared.Item;
import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Integer orderNumber = 0;
    private Double totalPrice;
    private Boolean orderStatus;

    private ObservableList<OrderRegel> observerListOrderregels;
    private List<OrderRegel> orderRegels;

    public Order(Integer orderNumber, Double totalPrice, Boolean orderStatus) {
        this.orderNumber = orderNumber;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        orderRegels = new ArrayList<>();
        observerListOrderregels = FXCollections.observableList(orderRegels);
    }

    public Order(Boolean orderStatus) {
        this.totalPrice = 0.0;
        this.orderStatus = orderStatus;
        orderRegels = new ArrayList<>();
        observerListOrderregels = FXCollections.observableList(orderRegels);
    }

    public void addItem(Item item, int amount) {
        OrderRegel orderRegel = new OrderRegel(item, amount);

        if (observerListOrderregels.contains(orderRegel)) {
            for (int i = 0; i < observerListOrderregels.size(); i++) {
                OrderRegel regel = observerListOrderregels.get(i);
                if (orderRegel.equals(regel)) {
                    int j = regel.getAmount();
                    observerListOrderregels.remove(regel);

                    int k = orderRegel.getAmount();
                    k += j;
                    orderRegel.setAmount(k);
                    observerListOrderregels.add(orderRegel);
                }
            }
        } else {
            observerListOrderregels.add(orderRegel);
        }
    }

    public void removeItem(Item item, int amount) {
        if (item != null) {
            observerListOrderregels.remove(item);
        }
    }

    public List<OrderRegel> getOrderRegel() {
        return orderRegels;
    }

    public void nextOrderNumber() {
        if (orderNumber < 100) {
            orderNumber++;
        } else if (orderNumber == 99) {
            orderNumber = 0;
        }
    }

    public void changeOrderStatus() {
        if (orderStatus == true) {
            orderStatus = false;
        } else if (orderStatus == false) {
            orderStatus = true;
        }
    }

    public void getTotalPrice() {
        for (OrderRegel orderregel : orderRegels) {
            totalPrice += orderregel.getItem().getPrice();
        }
    }
}