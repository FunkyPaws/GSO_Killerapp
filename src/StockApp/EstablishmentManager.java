package StockApp;

import Shared.Stock;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EstablishmentManager extends UnicastRemoteObject implements IEstabCentral {

    public EstablishmentManager() throws RemoteException {

    }

    @Override
    public Stock getStock(String estabName) {
        return null;
        // TODO dumy ding maken
    }
}
