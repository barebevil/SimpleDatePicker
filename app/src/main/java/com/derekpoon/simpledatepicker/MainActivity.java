package com.derekpoon.simpledatepicker;

import android.os.Bundle;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

//be sure to implement the interface in the activity

public class MainActivity extends AppCompatActivity implements DatePickerFragment.OnCompleteListener {

    private TextView displayDate;
    private Button btnShowDatePicker;
    private ArrayList<String> birthdays = new ArrayList<String>();
    private String dobVal = "";
    private Random rand = new Random();
    private int randIdx = 0;

    public void onComplete(String selectedDate) {
        // After the dialog fragment completes, it calls this callback.
        // use the string here
        displayDate.setText(selectedDate);

        //update original DOB value
        dobVal = selectedDate;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayDate = (TextView)findViewById(R.id.selected_date);
        btnShowDatePicker = (Button)findViewById(R.id.button);
        btnShowDatePicker.setOnClickListener(btnHandler);

        birthdays.add("10 JAN 1950");
        birthdays.add("03 MAR 1967");
        birthdays.add("18 JUN 1979");
        birthdays.add("21 OCT 2001");
        birthdays.add("09 DEC 2010");

        randIdx = rand.nextInt(birthdays.size());
        dobVal = birthdays.get(randIdx);

    }

    View.OnClickListener btnHandler = new View.OnClickListener() {
        public void onClick(View v) {
            DialogFragment picker = new DatePickerFragment();
            Bundle bundle = new Bundle();
            bundle.putString("DOB", dobVal);
            picker.setArguments(bundle);
            picker.show((MainActivity.this).getFragmentManager(),"datePicker");
        }
    };


//    public void showDatePickerDialog(View v) {
//        DialogFragment newFragment = new DatePickerFragment();
//        newFragment.show(getSupportFragmentManager(), "datePicker");
//    }
}