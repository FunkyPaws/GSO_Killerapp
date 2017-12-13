package Shared;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Item extends UnicastRemoteObject implements IItem {

    private String name;
    private Double price;
    private String description;
    private ItemCategory category;

    public Item(String name, Double price, String description, ItemCategory category) throws RemoteException {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public ItemCategory getCategory() {
        return category;
    }
}
