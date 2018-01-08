package shared;

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

    public Item(String name, Double price, ItemCategory category) {
        this.name = name;
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (price != null ? !price.equals(item.price) : item.price != null) return false;
        return category == item.category;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  name.toString();
    }
}
