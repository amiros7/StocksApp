package com.example.mstockslib.models;

import com.google.gson.annotations.SerializedName;

public class ChartAggregate {
    @SerializedName("v")
    private double volume;

    @SerializedName("vw")
    private double volumeWeightedAveragePrice;

    @SerializedName("o")
    private double open;

    @SerializedName("c")
    private double close;

    @SerializedName("h")
    private double high;

    @SerializedName("l")
    private double low;

    @SerializedName("t")
    private long timestamp;

    @SerializedName("n")
    private int numberOfTrades;

    // Getters and Setters
    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getVolumeWeightedAveragePrice() {
        return volumeWeightedAveragePrice;
    }

    public void setVolumeWeightedAveragePrice(double volumeWeightedAveragePrice) {
        this.volumeWeightedAveragePrice = volumeWeightedAveragePrice;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getNumberOfTrades() {
        return numberOfTrades;
    }

    public void setNumberOfTrades(int numberOfTrades) {
        this.numberOfTrades = numberOfTrades;
    }

    @Override
    public String toString() {
        return "ChartAggregate{" +
                "volume=" + volume +
                ", volumeWeightedAveragePrice=" + volumeWeightedAveragePrice +
                ", open=" + open +
                ", close=" + close +
                ", high=" + high +
                ", low=" + low +
                ", timestamp=" + timestamp +
                ", numberOfTrades=" + numberOfTrades +
                '}';
    }

}
