package org.example;

import java.util.Comparator;

public class AirfarePriceComparator implements Comparator<Airfare> {

    @Override
    public int compare(Airfare o1, Airfare o2) {
        if (o1.getPrice() < o2.getPrice()) {
            return -1;
        } else if (o1.getPrice() > o2.getPrice()) {
            return 1;
        } else return 0;
    }
}
