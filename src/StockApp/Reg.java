package StockApp;

import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Reg {

    private static final int portNumber = 1099;
    private static final String bindingName = "Server";
    private Registry registry = null;
    private EstablishmentManager manager;

    public Reg() {

        try {
            manager = new EstablishmentManager();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
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
