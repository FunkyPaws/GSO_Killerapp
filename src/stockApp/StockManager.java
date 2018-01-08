package stockApp;

import shared.Item;
import shared.ItemCategory;
import shared.Stock;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class StockManager extends UnicastRemoteObject implements IStockCentral {

    private Registry registry;
    private Publisher publisher;

    public StockManager() throws RemoteException {
        registry = new Registry(this);
        publisher = new Publisher();
        registry.RegistrateObject(publisher);
    }

    @Override
    public Stock getStock(Establishment establishment) {
        List<Stock> stocks = new ArrayList<>();
        Item item = new Item("Hamburger", 1.20, "is eetbaar", ItemCategory.Burger);
        Stock stock = new Stock(item.getName(), 10);
        stocks.add(stock);
        publisher.update(establishment.getName(), stocks);
        return null;
    }
}