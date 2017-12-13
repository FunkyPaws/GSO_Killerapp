package StockApp;

import Shared.Stock;

import java.rmi.Remote;

public interface IEstabCentral extends Remote {
    Stock getStock(String estabName);
}
