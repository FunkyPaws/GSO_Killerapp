package stockApp;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStockCentral extends Remote {
    void getStock(Establishment establishment) throws RemoteException;
}
