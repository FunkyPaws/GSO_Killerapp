package stockApp;

import orderApp.OrderRegel;
import orderApp.iOrderCentral;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class StockManager extends UnicastRemoteObject implements IStockCentral, iOrderCentral {

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

    @Override
    public void getOrderRegels(List<OrderRegel> orderRegels) throws RemoteException {

        for (OrderRegel orderregel : orderRegels) {
            System.out.println(orderregel.toString());
        }
    }
}