package com.example.ash.poopwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //days in calendar year
    private static final int WEEKSINYEAR = 52;
    //days in working week
    private static final int DAYSINWEEK = 5;
    //hours in working week
    private static final int HOURSINWEEK = 40;
    //working hours during 52-week year
    private static final int HOURSINYEAR = 2080;
    DecimalFormat df = new DecimalFormat("##.##");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v){
        EditText e1 = (EditText)findViewById(R.id.editYearly);
        EditText e2 = (EditText)findViewById(R.id.editTHours);
        EditText e3 = (EditText)findViewById(R.id.textAverageSalary);
        double salary = Double.parseDouble(e1.getText().toString());
        double hoursOnToilet = Double.parseDouble(e2.getText().toString());
        double netWorkingHours = HOURSINWEEK - hoursOnToilet;
        double hourlyRate = salary / HOURSINYEAR;

        e3.setText(String.valueOf(df.format(((hourlyRate * hoursOnToilet)* DAYSINWEEK) * WEEKSINYEAR)));
    }
}
