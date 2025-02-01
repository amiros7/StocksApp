package com.example.mstockslib;

import android.util.Log;

import com.example.mstockslib.models.ChartAggregate;
import com.example.mstockslib.models.StockDataResponse;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;

import java.util.ArrayList;
import java.util.List;

public class Candles {
    private List<CandleEntry> entries;

    public Candles(List<CandleEntry> entries) {
        this.entries = entries;
    }

    public Candles() {
        entries = new ArrayList<>();
    }

    public static Candles fromAggregate(List<ChartAggregate> aggregate) {
        if(aggregate == null) return null;
        Candles c = new Candles();
        List<CandleEntry> entries = new ArrayList<>();
        for (int x = 0; x < aggregate.size(); x++) {
            ChartAggregate agg = aggregate.get(x);
            Log.d(String.format("Aggregate %d", x), String.format("Open: %.2f, Close%.2f", agg.getOpen(), agg.getClose()));
            entries.add(new CandleEntry(x, (float)agg.getHigh(), (float)agg.getLow(), (float) agg.getOpen(), (float) agg.getClose()));
        }
        c.setEntries(entries);
        return c;
    }

    public List<CandleEntry> getEntries() {
        return entries;
    }

    public CandleDataSet toDataSet() {
        return new CandleDataSet(entries, "Data");
    }

    public void addEntry(CandleEntry entry) {
        entries.add(entry);
    }

    public void setEntries(List<CandleEntry> entries) {
        this.entries = entries;
    }

    public static Candles test() {
        Candles candles = new Candles();
        candles.addEntry(new CandleEntry(0, 80f, 90f, 70f, 85f)); // Up (green)
        candles.addEntry(new CandleEntry(1, 85f, 95f, 75f, 88f)); // Up (green)
        candles.addEntry(new CandleEntry(2, 88f, 75f, 82f, 85f)); // Down (red)
        candles.addEntry(new CandleEntry(3, 85f, 70f, 78f, 72f)); // Down (red)
        candles.addEntry(new CandleEntry(4, 72f, 68f, 70f, 70f)); // Down (red)
        candles.addEntry(new CandleEntry(5, 70f, 85f, 68f, 82f)); // Up (green)
        candles.addEntry(new CandleEntry(6, 82f, 78f, 80f, 75f)); // Down (red)
        candles.addEntry(new CandleEntry(7, 75f, 70f, 73f, 72f)); // Down (red)
        candles.addEntry(new CandleEntry(8, 72f, 82f, 70f, 80f)); // Up (green)
        candles.addEntry(new CandleEntry(9, 80f, 88f, 75f, 85f)); // Up (green)
        candles.addEntry(new CandleEntry(10, 85f, 92f, 82f, 90f)); // Up (green)
        candles.addEntry(new CandleEntry(11, 90f, 98f, 88f, 95f)); // Up (green)
        candles.addEntry(new CandleEntry(12, 95f, 88f, 90f, 85f)); // Down (red)
        candles.addEntry(new CandleEntry(13, 85f, 78f, 82f, 72f)); // Down (red)
        candles.addEntry(new CandleEntry(14, 72f, 70f, 70f, 68f)); // Down (red)
        return candles;
    }

}
