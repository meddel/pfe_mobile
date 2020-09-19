package com.mostdanger.drawerdemo.entities;

public class Station {
    private String name;
    private String address;
    private Double lon;
    private Double lat;

    public Station(String name, String address, Double lon, Double lat) {
        this.name = name;
        this.address = address;
        this.lon = lon;
        this.lat = lat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
