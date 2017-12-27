package MCDCentral;

import Shared.IEstabOrder;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static javafx.application.Application.launch;

public class MCDCentral  {

    private final String hostID = "localhost";
    private final int port = 1099;
    private IEstabOrder iEstabOrder;
    private Registry registry = null;

    public MCDCentral() {
        try
        {
            registry = LocateRegistry.getRegistry(hostID, port);
        }
        catch (RemoteException ex)
        {
            System.out.println("Client: Cannot locate registry");
            System.out.println("Client: RemoteException: " + ex.getMessage());
            registry = null;
        }

        if (registry != null)
        {
            System.out.println("Client: Registry located");
            try
            {
                iEstabOrder = (IEstabOrder) registry.lookup("Server");
            }
            catch (RemoteException ex)
            {
                System.out.println("Client: Cannot bind server");
                System.out.println("Client: RemoteException: " + ex.getMessage());
                iEstabOrder = null;
            }
            catch (NotBoundException ex)
            {
                System.out.println("Client: Cannot bind server");
                System.out.println("Client: NotBoundException: " + ex.getMessage());
                iEstabOrder = null;
            }
        }
        else
        {
            System.out.println("Client: Cannot locate registry");
            System.out.println("Client: Registry is null pointer");
        }

        if (iEstabOrder != null)
        {
            System.out.println("Client: server bound");
        }
        else
        {
            System.out.println("Client: server is null pointer");
        }
    }

    public static void main(String[] args) {

        launch(args);
    }

}
