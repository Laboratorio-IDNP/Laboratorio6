package com.example.laboratorio6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class PieChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.pieChart);
        int[] values = {20, 20, 40, 100};
        String[] data = {"Perú", "Brazil", "Colombia", "Bolivia"};
        linearLayout.addView(new PieChart(this, values, data));
    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}