package Shared;

import java.io.Serializable;

public class Stock implements IStock, Serializable {

    private String itemName;
    private Integer amount;
    private Item item;

    public Stock(String itemName, Integer amount) {
        this.itemName = itemName;
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
