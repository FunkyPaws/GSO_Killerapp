package StockApp;

import Shared.Stock;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EstablishmentManager extends UnicastRemoteObject implements IEstabCentral {

    private Reg registry;

    public EstablishmentManager() throws RemoteException {
        registry = new Reg(this);
    }

    @Override
    public Stock getStock(String estabName) {
        return null;
        // TODO dumy ding maken
    }
}