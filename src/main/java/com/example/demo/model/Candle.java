package com.example.demo.model;

public class Candle {
    public String time;
    public double open;
    public double high;
    public double low;
    public double close;
    public double volume;
    public double open_interest;

    public Candle() {}

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public double getOpen() {
        return open;
    }
    public void setOpen(double open) {
        this.open = open;
    }
    public double getHigh() {
        return high;
    }
    public void setHigh(double high) {
        this.high = high;
    }
    public double getLow() {
        return low;
    }
    public void setLow(double low) {
        this.low = low;
    }
    public double getClose() {
        return close;
    }
    public void setClose(double close) {
        this.close = close;
    }
    public double getVolume() {
        return volume;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }
    public double getOpen_interest() {
        return open_interest;
    }
    public void setOpen_interest(double open_interest) {
        this.open_interest = open_interest;
    }
}
