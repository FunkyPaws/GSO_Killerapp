package Shared;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Stock implements IStock, Serializable {

    private String itemName;
    private Integer amount;
    private Item item;

    public Stock(Integer amount) {
        this.itemName = item.getName();
        this.amount = amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public Integer getAmount() {
        return amount;
    }
}
