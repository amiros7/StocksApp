package com.example.stockstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.mstockslib.Candles;
import com.example.mstockslib.ChartFragment;
import com.example.stockstracker.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private ChartFragment chartFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Test chart fragment
        chartFragment = new ChartFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.chartFragmentContainer, chartFragment)
                .commit();

    }
}