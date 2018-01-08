package MCDCentral;

import shared.ICreator;
import shared.ISubscriber;
import shared.Stock;
import stockApp.IStockCentral;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class MCDCentral extends UnicastRemoteObject implements ISubscriber {

    private final String hostID = "localhost";
    private final int port = 1099;
    private IStockCentral iStockCentral;
    private Registry registry = null;
    private ICreator creator = null;

    public MCDCentral() throws RemoteException {
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
                iStockCentral = (IStockCentral) registry.lookup("Server");
            } catch (Exception ex) {
                System.out.println("Client: Cannot bind server");
                System.out.println("Client: RemoteException: " + ex.getMessage());
                ex.printStackTrace();
                iStockCentral = null;
            }
        } else {
            System.out.println("Client: Cannot locate registry");
            System.out.println("Client: Registry is null pointer");
        }
        if (iStockCentral != null) {
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
    public void update(String vestigingNaam, List<Stock> stocks) {
        System.out.println("Vestiging : " + vestigingNaam + "\nVoorraad: ");
        for (Stock stock : stocks) {
            System.out.println("Item: " + stock.getItemName() + ", Amount: " + stock.getAmount());
        }
    }

    public void getCreator() {
        if (registry != null) {
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
        } else {
            System.out.println("Client: Cannot locate registry");
            System.out.println("Client: Registry is null pointer");
        }

        if (creator != null) {
            try {
                creator.aanmelden(this);
                System.out.println("Client status: Aangemeld");
            } catch (RemoteException e) {
                System.out.println("Client status: Niet aangemeld");
                e.printStackTrace();
            }
        }
    }
}