package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ISubscriber extends Remote{
    // listner mcdCentrale

    /**
     * gets updated when the subscribie is updated.
     * @param vestigingNaam
     * @param stocks
     * @throws RemoteException
     */
    void update(String vestigingNaam, List<Stock> stocks)throws RemoteException;
}
