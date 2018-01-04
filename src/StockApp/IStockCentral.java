package StockApp;

import Shared.Stock;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStockCentral extends Remote {
    Stock getStock(String estabName) throws RemoteException;
}
