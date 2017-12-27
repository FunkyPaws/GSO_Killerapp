package Shared;

import java.util.List;

public interface ISubscriber {
    // listner mcd
    void update(String vestigingNaam, List<Stock> stock);
}
