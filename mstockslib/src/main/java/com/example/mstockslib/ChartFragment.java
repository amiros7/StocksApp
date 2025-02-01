package com.example.mstockslib;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.mstockslib.databinding.FragmentMainBinding;
import com.example.mstockslib.models.Callback;
import com.example.mstockslib.models.StockDataResponse;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.squareup.picasso.Picasso;

public class ChartFragment extends DialogFragment {
    private FragmentMainBinding binding;
    private final StockFetchTask fetcher = new StockFetchTask();
    private String selectedStartDate = "2024-01-01",
            selectedEndDate = "2024-02-01",
            selectedTimeFrame = "day";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    private CandleDataSet prepareCandleDataSet(Candles candles) {
        CandleDataSet set = candles.toDataSet();
        set.setDrawIcons(false);
        set.setIncreasingColor(Color.GREEN); // Color for up (green) candlesticks
        set.setIncreasingPaintStyle(Paint.Style.FILL); // Set the paint style to Fill for green candlesticks
        set.setDecreasingColor(Color.RED); // Color for down (red) candlesticks
        set.setShadowColorSameAsCandle(true); // Using the same color for shadows as the candlesticks
        set.setDrawValues(false);             // Hiding the values on the chart if not needed
        return set;
    }

    private void fetchQuery(String query) {
        fetcher.fetch(query, selectedStartDate, selectedEndDate, selectedTimeFrame, new Callback<StockDataResponse>() {
            @Override
            public void consume(StockDataResponse response) {
                updateUI(response);
            }

            @Override
            public void error(Throwable e) {
                if (e.getLocalizedMessage() != null)
                    Log.d("Error", e.getLocalizedMessage());
                e.printStackTrace();
            }
        });
    }


    private void updateUI(StockDataResponse response) {
        if (!response.valid()) return;
        requireActivity()
                .runOnUiThread(() -> {
                    Candles c = Candles.fromAggregate(response.getStockData().getResults());
                    if(c==null)return;
                    binding.companyLayout.getRoot().setVisibility(View.VISIBLE);
                    CandleDataSet dataSet = prepareCandleDataSet(c);
                    binding.companyLayout.candleStick.setData(new CandleData(dataSet));
                    binding.companyLayout.candleStick.invalidate();
                    binding.companyLayout.ticker.setText(response.getStockData().getTicker().toUpperCase());
                    binding.companyLayout.desc.setText(response.getProfile().getDescription());
                    binding.companyLayout.about.setText("About " + response.getProfile().getCompanyName().split(" ")[0]);
                    binding.companyLayout.companyFullName.setText(response.getProfile().getCompanyName());
                    Picasso.get().load(response.getCompanyThumbnail()).into(binding.companyLayout.tickerImage);
                });
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.companyLayout.getRoot().setVisibility(View.GONE);

        binding.companyLayout.candleStick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                while (!binding.companyLayout.candleStick.isFullyZoomedOut()) {
                    binding.companyLayout.candleStick.zoomOut();
                }
                return true;
            }
        });
        binding.companyLayout.chartSettingsBtn.setOnClickListener(v -> {
            new SettingsDialog((startDate, endDate, timeFrame) -> {
                ChartFragment.this.selectedStartDate = startDate;
                ChartFragment.this.selectedEndDate = endDate;
                ChartFragment.this.selectedTimeFrame = timeFrame;
                String symbol = fetcher.getLastSymbol();
                if (symbol != null)
                    fetchQuery(symbol);
            },selectedStartDate,selectedEndDate,selectedTimeFrame).show(getChildFragmentManager(), "Chart Settings");
        });

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (s.isEmpty()) {
                    binding.companyLayout.getRoot().setVisibility(View.GONE);
                    return true;
                }
                fetchQuery(s);
                return true;
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
