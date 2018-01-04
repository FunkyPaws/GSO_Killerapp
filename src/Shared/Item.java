package Shared;

import java.io.Serializable;

public class Item implements IItem, Serializable {

    private String name;
    private Double price;
    private String description;
    private ItemCategory category;

    public Item(String name, Double price, String description, ItemCategory category) {
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
