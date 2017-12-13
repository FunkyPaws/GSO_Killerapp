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
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setItem(Item item){
        this.item = item;
    }

}