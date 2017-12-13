package OrderApp;

import java.rmi.Remote;

public interface IEstabOrder extends Remote{
    void placeOrder();
}
