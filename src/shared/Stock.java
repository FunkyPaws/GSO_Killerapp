package shared;

import java.io.Serializable;

public class Stock implements IStock, Serializable {

    private String itemName;
    private Integer amount;
    private Item item;

    public Stock(Item item, Integer amount) {
        this.item = item;
        this.amount = amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String getItemName() {
        itemName = item.getName();
        return itemName;
    }

    @Override
    public Integer getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "item=" + itemName + "amount= " + amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        return getItemName() != null ? getItemName().equals(stock.getItemName()) : stock.getItemName() == null;
    }

    @Override
    public int hashCode() {
        return getItemName() != null ? getItemName().hashCode() : 0;
    }
}
