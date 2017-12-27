package StockApp;

import Shared.Stock;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEstabCentral extends Remote {
    Stock getStock(String estabName) throws RemoteException;
}
