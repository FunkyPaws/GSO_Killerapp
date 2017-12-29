package StockApp;

import Shared.Stock;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EstablishmentManager extends UnicastRemoteObject implements IEstabCentral {

    private Reg registry;
    private Publisher publisher;

    public EstablishmentManager() throws RemoteException {
        registry = new Reg(this);
        publisher = new Publisher();
        registry.RegistrateObject(publisher);
    }

    @Override
    public Stock getStock(String estabName) {
        return null;
        // TODO dumy ding maken
    }
}