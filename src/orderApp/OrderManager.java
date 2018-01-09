package orderApp;

import java.rmi.RemoteException;
import java.util.List;

public class OrderManager {

    private ClientComunicator com;

    public OrderManager(){
        com = new ClientComunicator();
    }

    public void Flikkerdiemeukdeanderekantin(List<OrderRegel> orderRegels) throws RemoteException {
        com.SendShit(orderRegels);
    }

}
