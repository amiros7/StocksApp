package com.example.mstockslib.network;


import com.example.mstockslib.models.StockDataResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StocksService {
    @GET("/stock_info/{symbol}")
    Call<StockDataResponse> getInfo(String symbol, @Query("start_date") String start_date, @Query("end_date") String end_date);
}
