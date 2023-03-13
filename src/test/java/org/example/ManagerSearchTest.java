package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ManagerSearchTest {
    Airfare moscowLondon = new Airfare(
            1,
            "DME",
            "LHR",
            27904,
            240
    );
    Airfare budapestAlicante = new Airfare(
            2,
            "BUD",
            "ALC",
            12246,
            190
    );
    Airfare berlinRomeA = new Airfare(
            3,
            "BER",
            "FCO",
            14951,
            136
    );
    Airfare berlinRomeB = new Airfare(
            4,
            "BER2",
            "FCO",
            12764,
            136
    );
    Airfare berlinRomeC = new Airfare(
            5,
            "BER",
            "FCO",
            14984,
            136
    );
    Airfare berlinRomeD = new Airfare(
            6,
            "BER",
            "FCO",
            13765,
            136
    );
    Airfare berlinRomeE = new Airfare(
            7,
            "BER",
            "FCO",
            13765,
            136
    );
    @Test
    void findAllSearchWithSort() {
        AirfareRepository repo = new AirfareRepository();
        ManagerSearch mgr = new ManagerSearch(repo);

        mgr.add(moscowLondon);
        mgr.add(budapestAlicante);
        mgr.add(berlinRomeA);
        mgr.add(berlinRomeB);
        mgr.add(berlinRomeC);
        mgr.add(berlinRomeD);
        mgr.add(berlinRomeE);

        Airfare[] expected = {berlinRomeD, berlinRomeE, berlinRomeA, berlinRomeC};
        Airfare[] actual = mgr.findAllSearch("BER", "FCO");

        Assertions.assertArrayEquals(expected, actual);
    }

}