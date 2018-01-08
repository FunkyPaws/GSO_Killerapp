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

    public Establishment(String name, String place) {
        this.name = name;
        this.place = place;

        stockItems = new ArrayList<>();
        observableListStockItems = FXCollections.observableList(stockItems);
    }

    public ObservableList<Stock> getObservableListStockItems() {
        return observableListStockItems;
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
    public void setPlace(String place) {
        this.place = place;
    }

    public List<Stock> getStockItems() {
        return stockItems;
    }
    public void setStockItems(List<Stock> stockItems) {
        this.stockItems = stockItems;
    }

    public void addStock(String itemname, Integer amount) {
        if(itemname !=null && amount!=null){
            Stock stock = new Stock(itemname, amount);
            stockItems.add(stock);
        }
    }

    public void removeStock(String itemname, Integer amount) {
        //TODO make methode complete
    }
}
