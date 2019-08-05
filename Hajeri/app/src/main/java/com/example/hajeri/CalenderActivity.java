package com.example.hajeri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

public class CalenderActivity extends AppCompatActivity {

    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        calendarView = findViewById(R.id.calendarView);

        String date  = String.valueOf(calendarView.getDate());

        Toast.makeText(this, "date" + date, Toast.LENGTH_SHORT).show();



    }
}
