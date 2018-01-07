package OrderApp;

import Shared.Item;

public class OrderRegel implements IOrderRegel {

    private Item item;
    private Integer amount;

    public OrderRegel(Item item, Integer amount) {
        this.item = item;
        this.amount = amount;
    }

    @Override
    public Item getItem(String itemName) {
        if (itemName == item.getName()) {
            return item;
        } else {
            return null;
        }
    }

    @Override
    public Item getItem() {
        return item;
    }

    @Override
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderRegel that = (OrderRegel) o;

        return item != null ? item.equals(that.item) : that.item == null;
    }

    @Override
    public int hashCode() {
        return item != null ? item.hashCode() : 0;
    }
}