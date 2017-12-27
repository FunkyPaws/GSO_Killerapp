package Shared;

import java.time.chrono.IsoChronology;

public interface ICreator {
    //accept specific subscriber
    void aanmelden(ISubscriber iSubscriber);
    void afmelden(ISubscriber iSubscriber);
    void update();
}
