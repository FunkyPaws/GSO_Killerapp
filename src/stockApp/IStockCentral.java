package stockApp;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStockCentral extends Remote {
    /**
     * get stock
     * @param establishment
     * @throws RemoteException
     */
    void getStock(Establishment establishment) throws RemoteException;
}
