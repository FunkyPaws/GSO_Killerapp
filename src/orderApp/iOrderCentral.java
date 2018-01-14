package orderApp;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface iOrderCentral extends Remote{
    /**
     *gets the orderregels of an order
     * @param orderRegels
     * @throws RemoteException
     */
    void getOrderRegels(List<OrderRegel> orderRegels)throws RemoteException;
}
