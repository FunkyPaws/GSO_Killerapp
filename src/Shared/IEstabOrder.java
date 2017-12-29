package Shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEstabOrder extends Remote{
    void placeOrder()throws RemoteException;
}
