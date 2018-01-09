package stockApp;

import javafx.collections.ListChangeListener;
import shared.Item;
import shared.ItemCategory;
import shared.Stock;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class StockManager extends UnicastRemoteObject implements IStockCentral, ListChangeListener<Stock> {

    private Registry registry;
    private Publisher publisher;
    private Establishment establishment;

    public StockManager() throws RemoteException {
        registry = new Registry(this);
        publisher = new Publisher();
        registry.RegistrateObject(publisher);
    }

    @Override
    public void getStock(Establishment establishment) {
        this.establishment = establishment;
        establishment.subscribe(this);

//        List<Stock> stocks = new ArrayList<>();
//        Item item = new Item("Hamburger", 1.20, "is eetbaar", ItemCategory.Burger);
//        Stock stock = new Stock(item.getName(), 10);
//        stocks.add(stock);
//        publisher.update(establishment.getName(), stocks);
        publisher.update(establishment.getName(), establishment.getStockItems());
    }

    @Override
    public void onChanged(Change c) {
        if(c.wasUpdated()){
            System.out.println("stuff changed" + establishment.getStockItems().size());
            publisher.update(establishment.getName(), establishment.getStockItems());
        }
    }
}