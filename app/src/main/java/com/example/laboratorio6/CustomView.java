package com.example.laboratorio6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.Toast;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CustomView extends View {

    public CustomView(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawRGB(255,255,255);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Paint pincel1 = new Paint();

        pincel1.setARGB(255,242,105,11);

        int dataNumber = 4;
        int padding = 10;
        int paddingRight = 0;
        int paddingLeft = 0;
        int numSpacesBetweenBars = dataNumber - 1;

        //Al ancho se le quita los bordes de ambos lados
        int newWidth = width-padding*2;
        int spaceBetweenBars = calculateSpace(newWidth, dataNumber);
        int jump = newWidth - (spaceBetweenBars * numSpacesBetweenBars);
        jump = jump / dataNumber;

        // (ancho por la izquierda, altura por arriba, ancho hacia la derecha, altura de por abajo)
        paddingLeft = padding;
        paddingRight = jump + padding;

        //Peliculas favoritas
        Map<String, Integer> mapData = new HashMap<String, Integer>();
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


        for (int i = 0; i < dataNumber; ++i) {
            canvas.drawRect(paddingLeft, 1000, paddingRight,height - padding, pincel1);
            paddingLeft = paddingRight + spaceBetweenBars;
            paddingRight = paddingRight + jump + spaceBetweenBars;
        }

        /*canvas.drawRect(10,10,272 + 0,alto-10, pincel1);
        canvas.drawRect(272 + 4,10,272 + 262,alto-10, pincel1);
        canvas.drawRect(534 + 4,10,534 + 262,alto-10, pincel1);
        canvas.drawRect(796 + 4,10,796 + 262,alto-10, pincel1);*/
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
}
