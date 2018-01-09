package orderApp;

import java.rmi.RemoteException;
import java.util.List;

public class OrderManager {

    private ClientComunicator com;

    public OrderManager(){
        com = new ClientComunicator();
    }

    public void sendListToStock(List<OrderRegel> orderRegels) throws RemoteException {
        com.sendListOrderRegels(orderRegels);
    }

}
