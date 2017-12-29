package MCDCentral;

import Shared.IEstabOrder;
import Shared.ISubscriber;
import Shared.Stock;
import StockApp.IEstabCentral;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import static javafx.application.Application.launch;

public class MCDCentral implements ISubscriber {

    private final String hostID = "localhost";
    private final int port = 1099;
    private IEstabCentral iEstabCentral;
    private Registry registry = null;

    public MCDCentral() {
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
            } catch (RemoteException ex) {
                System.out.println("Client: Cannot bind server");
                System.out.println("Client: RemoteException: " + ex.getMessage());
                iEstabCentral = null;
            } catch (NotBoundException ex) {
                System.out.println("Client: Cannot bind server");
                System.out.println("Client: NotBoundException: " + ex.getMessage());
                iEstabCentral = null;
            }
        } else {
            System.out.println("Client: Cannot locate registry");
            System.out.println("Client: Registry is null pointer");
        }
        if (iEstabCentral != null) {
            System.out.println("Client: server bound");
        } else {
            System.out.println("Client: server is null pointer");
        }
    }

    public static void main(String[] args) {
        MCDCentral central = new MCDCentral();
    }

    @Override
    public void update(String vestigingNaam, List<Stock> stock) {
        System.out.println("Vestiging : " + vestigingNaam + "\n" + "items: " + stock);
    }


}