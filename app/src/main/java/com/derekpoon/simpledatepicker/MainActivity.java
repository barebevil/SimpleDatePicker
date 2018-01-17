package com.derekpoon.simpledatepicker;

import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

//be sure to implment the interface in the activity

public class MainActivity extends AppCompatActivity implements DatePickerFragment.OnCompleteListener {

    private TextView displayDate;

    public void onComplete(String selectedDate) {
        // After the dialog fragment completes, it calls this callback.
        // use the string here
        displayDate.setText(selectedDate);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayDate = (TextView)findViewById(R.id.selected_date);

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}