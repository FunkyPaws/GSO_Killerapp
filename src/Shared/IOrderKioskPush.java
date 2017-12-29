package Shared;

import OrderApp.OrderRegel;

import java.rmi.Remote;
import java.util.List;

public interface IOrderKioskPush extends Remote {
    void update(List<OrderRegel> orderRegels);
}
