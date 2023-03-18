package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ManagerSearchTest {
    AirfarePriceComparator priceComparator = new AirfarePriceComparator();
    AirfareTimeComparator timeComparator = new AirfareTimeComparator();
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
            139
    );
    Airfare berlinRomeC = new Airfare(
            5,
            "BER",
            "FCO",
            14984,
            130
    );
    Airfare berlinRomeD = new Airfare(
            6,
            "BER",
            "FCO",
            13765,
            137
    );
    Airfare berlinRomeE = new Airfare(
            7,
            "BER",
            "FCO",
            13765,
            131
    );

    //В связи с личными ограничениями по времени реализован только минимальный набор тестов
    @Test
    void findAllSearchWithSortMinPrice() {
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
        Airfare[] actual = mgr.findAllSearch("BER", "FCO", priceComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void findAllSearchMinPriceOneTicket() {
        AirfareRepository repo = new AirfareRepository();
        ManagerSearch mgr = new ManagerSearch(repo);

        mgr.add(moscowLondon);
        mgr.add(budapestAlicante);
        mgr.add(berlinRomeA);
        mgr.add(berlinRomeB);
        mgr.add(berlinRomeC);
        mgr.add(berlinRomeD);
        mgr.add(berlinRomeE);

        Airfare[] expected = {budapestAlicante};
        Airfare[] actual = mgr.findAllSearch("BUD", "ALC", priceComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void findAllSearchMinPriceZeroTicket() {
        AirfareRepository repo = new AirfareRepository();
        ManagerSearch mgr = new ManagerSearch(repo);

        mgr.add(moscowLondon);
        mgr.add(budapestAlicante);
        mgr.add(berlinRomeA);
        mgr.add(berlinRomeB);
        mgr.add(berlinRomeC);
        mgr.add(berlinRomeD);
        mgr.add(berlinRomeE);

        Airfare[] expected = {};
        Airfare[] actual = mgr.findAllSearch("BKD", "ALC", priceComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void findAllSearchWithSortMinTime() {
        AirfareRepository repo = new AirfareRepository();
        ManagerSearch mgr = new ManagerSearch(repo);

        mgr.add(moscowLondon);
        mgr.add(budapestAlicante);
        mgr.add(berlinRomeA);
        mgr.add(berlinRomeB);
        mgr.add(berlinRomeC);
        mgr.add(berlinRomeD);
        mgr.add(berlinRomeE);

        Airfare[] expected = {berlinRomeC, berlinRomeE, berlinRomeA, berlinRomeD};
        Airfare[] actual = mgr.findAllSearch("BER", "FCO", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void findAllSearchMinTimeOneTicket() {
        AirfareRepository repo = new AirfareRepository();
        ManagerSearch mgr = new ManagerSearch(repo);

        mgr.add(moscowLondon);
        mgr.add(budapestAlicante);
        mgr.add(berlinRomeA);
        mgr.add(berlinRomeB);
        mgr.add(berlinRomeC);
        mgr.add(berlinRomeD);
        mgr.add(berlinRomeE);

        Airfare[] expected = {budapestAlicante};
        Airfare[] actual = mgr.findAllSearch("BUD", "ALC", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void findAllSearchMinTimeZeroTicket() {
        AirfareRepository repo = new AirfareRepository();
        ManagerSearch mgr = new ManagerSearch(repo);

        mgr.add(moscowLondon);
        mgr.add(budapestAlicante);
        mgr.add(berlinRomeA);
        mgr.add(berlinRomeB);
        mgr.add(berlinRomeC);
        mgr.add(berlinRomeD);
        mgr.add(berlinRomeE);

        Airfare[] expected = {};
        Airfare[] actual = mgr.findAllSearch("BUD", "JDB", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }



}