package orderApp;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface iOrderCentral extends Remote{
    void getOrderRegels(List<OrderRegel> orderRegels)throws RemoteException;
}
