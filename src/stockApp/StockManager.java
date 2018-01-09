package stockApp;

import javafx.collections.ListChangeListener;
import shared.Stock;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StockManager extends UnicastRemoteObject implements IStockCentral{

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
        //establishment.subscribe(this);
        publisher.update(establishment.getName(), establishment.getStockItems());
    }
}