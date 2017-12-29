package MCDCentral;

import Shared.ICreator;
import Shared.ISubscriber;
import Shared.Stock;
import StockApp.IEstabCentral;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class MCDCentral extends UnicastRemoteObject implements ISubscriber {

    private final String hostID = "localhost";
    private final int port = 1099;
    private IEstabCentral iEstabCentral;
    private Registry registry = null;
    private ICreator creator = null;

    public MCDCentral() throws RemoteException{
        try {
            registry = LocateRegistry.getRegistry(hostID, port);
        } catch (RemoteException ex) {
            System.out.println("Client: Cannot locate registry");
            System.out.println("Client: RemoteException: " + ex.getMessage());
            registry = null;
        }

        if (registry != null) {
            System.out.println("Client: Registry located");
            try {
                iEstabCentral = (IEstabCentral) registry.lookup("Server");
            } catch (Exception ex) {
                System.out.println("Client: Cannot bind server");
                System.out.println("Client: RemoteException: " + ex.getMessage());
                ex.printStackTrace();
                iEstabCentral = null;
            }

        } else {
            System.out.println("Client: Cannot locate registry");
            System.out.println("Client: Registry is null pointer");
        }
        if (iEstabCentral != null) {
            System.out.println("Client: server bound");
            getCreator();
        } else {
            System.out.println("Client: server is null pointer");
        }
    }

    public static void main(String[] args) {
        try {
            MCDCentral central = new MCDCentral();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String vestigingNaam, List<Stock> stock) {
        System.out.println("Vestiging : " + vestigingNaam + "\n" + "items: " + stock);
    }

    public void getCreator(){
        if(registry !=null) {
            try {
                creator = (ICreator) registry.lookup("publisher");
                System.out.println("publisher found");
            } catch (RemoteException ex) {
                System.out.println("Client: Cannot bind publisher");
                System.out.println("Client: RemoteException: " + ex.getMessage());
                creator = null;
            } catch (NotBoundException ex) {
                System.out.println("Client: Cannot bind publisher");
                System.out.println("Client: NotBoundException: " + ex.getMessage());
                creator = null;
            }
        }else {
            System.out.println("Client: Cannot locate registry");
            System.out.println("Client: Registry is null pointer");
        }

        if (creator != null) {
            try {
                creator.aanmelden(this);
                System.out.println("Client: Aangemeld");
            } catch (RemoteException e) {
                System.out.println("Client: niet aangemeld");
                e.printStackTrace();
            }
        }
    }
}