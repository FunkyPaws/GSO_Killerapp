package StockApp;

import Shared.Item;
import Shared.Stock;

import java.util.ArrayList;
import java.util.List;

public class Establishment {
    private String name;
    private String place;

    private List<Item> Items;
    private List<Stock> StockItems;

    public Establishment(String name, String place) {
        this.name = name;
        this.place = place;

        Items = new ArrayList<>();
        StockItems = new ArrayList<>();
    }

    public void addStock(String itemname, Integer amount) {
//TODO make methode complete
    }

    public void removeStock(String itemname, Integer amount) {
//TODO make methode complete
    }
}
