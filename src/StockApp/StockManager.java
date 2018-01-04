package StockApp;

import Shared.Item;
import Shared.ItemCategory;
import Shared.Stock;

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
    public Stock getStock(String estabName) {
        List<Stock> stocks = new ArrayList<>();
        Item item = new Item("Hamburger", 1.20, "is eetbaar", ItemCategory.Burger);
        Stock stock = new Stock(item.getName(), 10);
        stocks.add(stock);
        publisher.update("Henkus", stocks);
        return null;
    }
}