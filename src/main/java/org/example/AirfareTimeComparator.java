package org.example;
import java.util.Comparator;

public class AirfareTimeComparator implements Comparator<Airfare> {

    @Override
    public int compare(Airfare o1, Airfare o2) {
        if (o1.getTravelTime() < o2.getTravelTime()) {
            return -1;
        } else if (o1.getTravelTime() > o2.getTravelTime()) {
            return 1;
        } else return 0;
    }
}