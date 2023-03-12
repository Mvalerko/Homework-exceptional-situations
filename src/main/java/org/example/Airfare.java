package org.example;

public class Airfare implements Comparable<Airfare> {
    protected int id;
    protected int price;
    protected String departureAirport;
    protected String arrivalAirport;
    protected int travelTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int priceOpt) {
        this.price = price;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirportOpt) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirportOpt) {
        this.arrivalAirport = arrivalAirport;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTimeOpt) {
        this.travelTime = travelTime;
    }

    public Airfare(int idOpt, String departureAirportOpt, String arrivalAirportOpt, int priceOpt, int travelTimeOpt) {
        this.id = idOpt;
        this.departureAirport = departureAirportOpt;
        this.price = priceOpt;
        this.arrivalAirport = arrivalAirportOpt;
        this.travelTime = travelTimeOpt;
    }

    @Override
    public int compareTo(Airfare c) {
        if (this.price < c.price) {
            return -1;
        } else if (this.price > c.price) {
            return 1;
        } else {
            return 0;
        }
    }
}
