package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity<sets, weight> extends AppCompatActivity {

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
public static int reps;
public static int sets;
public static int weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),getString(R.string.datePicker));
    }
    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string + "/" + year_string);
        Toast.makeText(this, getString(R.string.date) + dateMessage,
                Toast.LENGTH_SHORT).show();
    }

    public void showTimePicker(View view) {
    }
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment1 = new TimePickerFragment();
        newFragment1.show(getSupportFragmentManager(), getString(R.string.timepicker));
    }
    public void processTimePickerResult(int hour, int minutes) {
        String hour_string = Integer.toString(hour);
        String minutes_string = Integer.toString(minutes);
        String timeMessage = (hour_string +
                ":" + minutes_string);
        Toast.makeText(this, getString(R.string.time) + timeMessage,
                Toast.LENGTH_SHORT).show();
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}