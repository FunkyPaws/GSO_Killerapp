package StockApp;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Registry {

    // server
    private static final int portNumber = 1099;
    private static final String bindingName = "Server";
    private static final String PROTOCOL = "java.rmi.server.hostname";
    private static String HOST = "127.0.0.1";

    //if connected to wifi: 192.168.0.25
    // if not connected to wifi: 127.0.0.1

    private java.rmi.registry.Registry registry = null;
    private IStockCentral manager;

    public Registry(StockManager manager) {
        this.manager = manager;
//        setHost();
        try {
            System.setProperty(PROTOCOL, HOST);
            System.out.println("java.rmi.server.hostname = " + System.getProperty("java.rmi.server.hostname"));
            registry = LocateRegistry.createRegistry(portNumber);
            System.out.println("registry:" + registry.toString());
            System.out.println("Server: Registry created on port number " + portNumber);
        } catch (RemoteException e) {
            System.out.println("Server: Cannot create registry\n" + "Server: RemoteException: " + e.getMessage());
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

    public void RegistrateObject(Publisher publisher) {
        try {
            if (publisher != null) {
                registry.rebind("publisher", publisher);
                System.out.println(registry.list());
            }
        } catch (RemoteException e) {
            System.out.println("cannot bind publisher");
            e.printStackTrace();
        }
    }

    public void setHost() {
        try {
            HOST = InetAddress.getLocalHost().toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}