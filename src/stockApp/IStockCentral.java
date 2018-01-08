package stockApp;

import shared.Stock;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStockCentral extends Remote {
    Stock getStock(Establishment establishment) throws RemoteException;
}
