package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICreator  extends Remote{
    //accept specific subscriber

    /**
     * subscribes a listner
     * @param iSubscriber
     * @throws RemoteException
     */
    void aanmelden(ISubscriber iSubscriber)throws RemoteException;

    /**
     * de-subscribes a listner
     * @param iSubscriber
     * @throws RemoteException
     */
    void afmelden(ISubscriber iSubscriber)throws RemoteException;

    /**
     * updates the listner when there is change
     * @param vestigingNaam
     * @param stock
     * @throws RemoteException
     */
    void update(String vestigingNaam, List<Stock> stock)throws RemoteException;
}
