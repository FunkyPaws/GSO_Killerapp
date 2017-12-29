package StockApp;

import Shared.ICreator;
import Shared.ISubscriber;
import Shared.Stock;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Publisher extends UnicastRemoteObject implements ICreator{
    private List<ISubscriber> subscribers = new ArrayList<>();

    protected Publisher() throws RemoteException {
    }

    @Override
    public void aanmelden(ISubscriber iSubscriber) {
        if(!subscribers.contains(iSubscriber)){
            subscribers.add(iSubscriber);
        }
    }

    @Override
    public void afmelden(ISubscriber iSubscriber) {
        if(subscribers.contains(iSubscriber)){
            subscribers.remove(iSubscriber);
        }
    }

    @Override
    public void update(String vestigingNaam, List<Stock> stock) {
        for (ISubscriber iSubscriber: subscribers){
            try {
                iSubscriber.update(vestigingNaam, stock);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}