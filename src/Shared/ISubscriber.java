package Shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ISubscriber extends Remote{
    // listner mcdCentrale
    void update(String vestigingNaam, List<Stock> stocks)throws RemoteException;
}
