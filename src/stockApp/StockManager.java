package stockApp;

import javafx.collections.ListChangeListener;
import orderApp.OrderRegel;
import orderApp.iOrderCentral;
import shared.Stock;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class StockManager extends UnicastRemoteObject implements IStockCentral, iOrderCentral {

    private Registry registry;
    private Publisher publisher;
    private Establishment establishment;

    public StockManager(Establishment establishment) throws RemoteException {
        registry = new Registry(this);
        publisher = new Publisher();
        registry.RegistrateObject(publisher);
        this.establishment = establishment;
    }

    @Override
    public void getStock(Establishment establishment) {
        this.establishment = establishment;
        publisher.update(establishment.getName(), establishment.getStockItems());
    }

    @Override
    public void getOrderRegels(List<OrderRegel> orderRegels) throws RemoteException {
        for (OrderRegel orderregel : orderRegels) {
            establishment.removeStock(orderregel.getItem(), orderregel.getAmount());
            System.out.println(orderregel.toString());
        }
    }
}