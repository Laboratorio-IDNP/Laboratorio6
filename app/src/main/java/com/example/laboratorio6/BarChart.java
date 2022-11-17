package com.example.laboratorio6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class BarChart extends View {
    private Map<String, Integer> mapData;

    public BarChart(Context context, Map<String, Integer> mapData) {
        super(context);
        this.mapData = mapData;
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawRGB(255,255,255);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Paint pincel1 = new Paint();

        pincel1.setARGB(255,242,105,11);


        int dataNumber = mapData.size();
        int maxValueOfMapData = Collections.max(mapData.entrySet(), Map.Entry.comparingByValue()).getValue();

        int padding = 10;
        int paddingRight = 0;
        int paddingLeft = 0;
        int numSpacesBetweenBars = dataNumber - 1;
        System.out.println("PPPPPPPP " + height);
        System.out.println("wWWWWWWWWW " + width);

        //Al ancho se le quita los bordes de ambos lados
        int newWidth = width-padding*2;
        int spaceBetweenBars = calculateSpace(newWidth, dataNumber);
        int jump = newWidth - (spaceBetweenBars * numSpacesBetweenBars);
        jump = jump / dataNumber;

        // (ancho por la izquierda, altura por arriba, ancho hacia la derecha, altura de por abajo)
        paddingLeft = padding;
        paddingRight = jump + padding;

        for (Integer value : mapData.values()) {
            //canvas.drawRect(paddingLeft, height - value, paddingRight,height - padding, pincel1);
            canvas.drawRect(paddingLeft, height - rescaleBar(value, maxValueOfMapData), paddingRight,height - padding, pincel1);
            paddingLeft = paddingRight + spaceBetweenBars;
            paddingRight = paddingRight + jump + spaceBetweenBars;
        }
    }

    private int calculateSpace(int wideSize, int numBarGraphs) {
        int numSpaces = numBarGraphs - 1;
        int ws = wideSize - numSpaces;
        int wideSpace = 1;

        while(ws % numBarGraphs != 0) {
            ws -= numSpaces;
            wideSpace = wideSpace + 1;
        }
        return wideSpace;
    }

    private int rescaleBar(int value, int maxValue) {
        //El maximo es 1900
        return (value * 1400) / maxValue;
    }
}
