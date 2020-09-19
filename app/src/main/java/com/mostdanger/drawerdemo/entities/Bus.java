package com.mostdanger.drawerdemo.entities;

public class Bus {

    private Integer num;
    private String station;
    private String date ;

    public Bus(Integer num, String station, String date) {
        this.num = num;
        this.station = station;
        this.date = date;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "num=" + num +
                ", station='" + station + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
