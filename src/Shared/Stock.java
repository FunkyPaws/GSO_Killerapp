package Shared;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Stock extends UnicastRemoteObject implements IStock {

    private String itemName;
    private Integer amount;
    private Item item;

    public Stock(Integer amount) throws RemoteException {
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
