package com.example.mstockslib;


import com.example.mstockslib.models.Callback;
import com.example.mstockslib.models.StockDataResponse;
import com.example.mstockslib.network.Api;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class StockFetchTask {

    private static String BASE_URL = "https://stockstrackerbackend.onrender.com";
    private final Api api = new Api();
    private static final long TIMEOUT = 2000L;
    private final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(2);

    private ScheduledFuture<?> scheduledTask;

    private String timeFrame = "day";
    private String lastSymbol;

    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }

    public String getTimeFrame() {
        return timeFrame;
    }

    public String getLastSymbol() {
        return lastSymbol;
    }

    private static String requestUrl(String symbol, String startDate, String endDate, String timeFrame) {
        return BASE_URL + "/stock_info/" + symbol + "?start_date=" + startDate + "&end_date=" + endDate + "&timeFrame=" + timeFrame;
    }

    public void fetch(String symbol, String startDate, String endDate, String timeFrame, Callback<StockDataResponse> callback) {
        lastSymbol = symbol;
        if (scheduledTask != null) {
            scheduledTask.cancel(true);
        }
        scheduledTask = exec.schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    StockDataResponse data = api.get(
                            requestUrl(symbol, startDate, endDate, timeFrame),
                            StockDataResponse.class
                    );
                    callback.consume(data);
                } catch (Exception e) {
                    callback.error(e);
                }

            }
        }, TIMEOUT, TimeUnit.MILLISECONDS);
    }


}
