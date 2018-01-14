package stockApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Item;
import shared.Stock;
import java.util.ArrayList;
import java.util.List;

public class Establishment {
    private String name;
    private String place;

    private List<Stock> stockItems;
    private ObservableList<Stock> observableListStockItems;

    private List<Item> items;
    private ObservableList<Item> itemObservableListItems;

    public Establishment(String name, String place) {
        this.name = name;
        this.place = place;

        stockItems = new ArrayList<>();
        observableListStockItems = FXCollections.observableList(stockItems);

        items = new ArrayList<>();
        itemObservableListItems = FXCollections.observableList(items);

    }

    public ObservableList<Stock> getObservableListStockItems() {
        return observableListStockItems;
    }

    public ObservableList<Item> getItemObservableListItems() {
        return itemObservableListItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public List<Stock> getStockItems() {
        return stockItems;
    }

    public void addStock(Item item, Integer amount) {
        int x = 0;
        Stock stock = new Stock(item, amount);
        if (observableListStockItems.contains(stock)) {
            for (int i = 0; i < observableListStockItems.size(); i++) {
                Stock stock1 = observableListStockItems.get(i);
                if (stock.equals(stock1)) {
                    x = stock1.getAmount();
                    int k = stock.getAmount();
                    observableListStockItems.remove(stock1);
                    k += x;
                    stock.setAmount(k);
                    observableListStockItems.add(stock);
                    break;
                }
            }
        } else {
            observableListStockItems.add(stock);
        }
    }

    public void addItems(Item item) {
        if (item != null) {
            itemObservableListItems.add(item);
        }
    }

    public void removeStock(Item item, Integer amount) {
        //TODO make methode complete
        int j = 0;
        Stock stock = new Stock(item, amount);
        if (observableListStockItems.contains(stock)) {
            for (int i = 0; i < observableListStockItems.size(); i++) {
                Stock stock1 = observableListStockItems.get(i);
                if (stock.equals(stock1)) {
                    j = stock1.getAmount();
                    int k = stock.getAmount();
                    j -= k;
                    stock1.setAmount(j);
                }
            }
        } else {
            System.out.println("the stock items doesn't exist");
        }


    }
}