package com.example.mstockslib;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.mstockslib.databinding.SettingsDialogBinding;

public class SettingsDialog extends DialogFragment {

    private SettingsDialogBinding binding;

    private final SettingsCallback callback;

    public SettingsDialog(SettingsCallback callback, String startDate, String endDate, String timeFrame) {
        this.callback = callback;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timeFrame = timeFrame;
    }

    public interface SettingsCallback {
        void saveSettings(
                String startDate,
                String endDate,
                String timeFrame
        );
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = SettingsDialogBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    private String timeFrame = "day";

    private String startDate = "2024-01-01";
    private String endDate = "2024-01-02";

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.oneDay.setOnClickListener(v -> updateTimeFrame("day"));
        binding.oneWeek.setOnClickListener(v -> updateTimeFrame("week"));
        binding.oneMonth.setOnClickListener(v -> updateTimeFrame("month"));

        updateStartDate(startDate);
        updateEndDate(endDate);
        updateTimeFrame(timeFrame);
        binding.chooseStartDateBtn.setOnClickListener(v -> {
            DatePickerDialog dialog = new DatePickerDialog(requireContext());
            dialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    String formatMonth = "0"+(month + 1);
                    updateStartDate(year + "-" + (formatMonth).substring(formatMonth.length()-2) + "-" + day);
                }
            });
            dialog.show();
        });
        binding.chooseEndDateBtn.setOnClickListener(v -> {
            DatePickerDialog dialog = new DatePickerDialog(requireContext());
            dialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    String formatMonth = "0"+(month + 1);
                    updateEndDate(year + "-" + (formatMonth).substring(formatMonth.length()-2) + "-" + day);
                }
            });
            dialog.show();
        });
        binding.saveSettingwsBtn.setOnClickListener(v -> {
            callback.saveSettings(startDate, endDate, timeFrame);
            dismiss();
        });
        binding.closeBtn.setOnClickListener(v -> dismiss());
    }

    private void updateStartDate(String startDate) {
        this.startDate = startDate;
        binding.startDateTv.setText(String.format("Start Date: %s", startDate));
    }

    private void updateEndDate(String endDate) {
        this.endDate = endDate;
        binding.endDateTv.setText(String.format("End Date: %s", endDate));
    }

    private void updateTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
        binding.timeFrameTv.setText(String.format("Time Frame: 1 %s", (String.valueOf(timeFrame.charAt(0))).toUpperCase() + timeFrame.substring(1)));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
