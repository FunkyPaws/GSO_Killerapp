package Shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICreator  extends Remote{
    //accept specific subscriber
    void aanmelden(ISubscriber iSubscriber)throws RemoteException;
    void afmelden(ISubscriber iSubscriber)throws RemoteException;
    void update(String vestigingNaam, List<Stock> stock)throws RemoteException;
}
