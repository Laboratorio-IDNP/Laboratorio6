package com.example.laboratorio6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;

public class BarChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.layout1);
        BarChar fondo = new BarChar(this);
        layout1.addView(fondo);
    }
}