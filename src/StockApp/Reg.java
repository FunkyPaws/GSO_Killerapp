package StockApp;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Reg {

    // server
    private static final int portNumber = 1099;
    private static final String bindingName = "Server";
    private Registry registry = null;
    private EstablishmentManager manager;

    public Reg(EstablishmentManager manager) {
            this.manager = manager;
        try {
            registry = LocateRegistry.createRegistry(portNumber);
            System.out.println("created reg: " + registry.toString());
        } catch (RemoteException e) {
            System.out.println("Cannot create reg \n" + "exception: " + e.getMessage());
            e.printStackTrace();
            registry = null;
        }
        try {
            registry.rebind(bindingName, manager);
        } catch (RemoteException e) {
            System.out.println("cannot bind manager");
            e.printStackTrace();
        }
    }
}
