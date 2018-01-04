package OrderApp;

import Shared.Item;
import java.util.ArrayList;
import java.util.List;

public class Order{

    private Integer orderNumber = 0;
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

    public Order(Boolean orderStatus) {
        this.totalPrice = 0.0;
        this.orderStatus = orderStatus;
        orderRegels = new ArrayList<>();
    }

    public void addItem(Item item, int amount) {
        int i = 0;
        if(orderRegels.contains(item)){
            for (OrderRegel orderRegel : orderRegels) {
                if(orderRegel.getItem().equals(item)){
                   i = orderRegel.getAmount();
                   i += amount;
                   orderRegel.setAmount(i);
                }
            }
        } else if(!orderRegels.contains(item)){
        OrderRegel regel = new OrderRegel(item, amount);
        orderRegels.add(regel);
        }
    }

    public void removeItem(Item item, int amount) {
        if(item != null) {
            orderRegels.remove(item);
        }
    }

    public List<OrderRegel> getOrderRegel() {
        return orderRegels;
    }

    public void nextOrderNumber() {
        if(orderNumber < 100){
            orderNumber ++;
        } else if(orderNumber == 99){
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

    public void getTotalPrice(){
        for (OrderRegel orderregel: orderRegels) {
            totalPrice += orderregel.getItem().getPrice();
        }
    }
}