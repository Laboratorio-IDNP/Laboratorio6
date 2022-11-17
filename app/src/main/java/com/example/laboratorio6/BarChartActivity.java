package com.example.laboratorio6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class BarChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        Map<String, Integer> mapData = new LinkedHashMap<String, Integer>();
        mapData.put("Argentina", 21);
        mapData.put("Bolivia", 46);
        mapData.put("Brazil", 28);
        mapData.put("Canada", 14);
        mapData.put("Chile", 24);
        mapData.put("Colombia", 27);
        mapData.put("Ecuador", 34);
        mapData.put("Guyana", 28);
        mapData.put("Mexico", 29);
        mapData.put("Peru", 33);
        mapData.put("U.S.A", 16);
        mapData.put("Uruguay", 17);
        mapData.put("Venezuela", 26);

        /*Random r = new Random();
        for(int i = 0; i < 50; i++) {
            mapData.put("Text"+i, r.nextInt(100)+10);
        }*/

        LinearLayout layout1 = (LinearLayout) findViewById(R.id.layout1);
        BarChart barChart = new BarChart(this, mapData);
        layout1.addView(barChart);
    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}