package com.example.laboratorio6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.Toast;

public class CustomView extends View {

    public CustomView(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawRGB(255,255,255);
        int ancho=canvas.getWidth();
        int alto = canvas.getHeight();
        Paint pincel1=new Paint();

        pincel1.setARGB(255,242,105,11);


        int dataNumber = 10;
        int padding = 10;
        int paddingRight = 0;
        int paddingLeft = 0;
        int numSpacesBetweenBars = dataNumber - 1;

        //Al ancho se le quita los bordes de ambos lados
        int newWidth = ancho-padding*2;
        int spaceBetweenBars = calculateSpace(newWidth, dataNumber);
        int jump = newWidth - (spaceBetweenBars * numSpacesBetweenBars);
        jump = jump / dataNumber;

        System.out.println("WWWWWWWWWWW  " + spaceBetweenBars);


        // (ancho por la izquierda, altura por arriba, ancho hacia la derecha, altura de por abajo)
        //canvas.drawRect(10,10,ancho-10,alto-10, pincel1);
        paddingLeft = padding;
        paddingRight = jump;
        for (int i = 1; i <= dataNumber; ++i) {

            canvas.drawRect(paddingLeft + padding,10,paddingRight + padding,alto-10, pincel1);
            //System.out.println("WWWWWWWWWWW  " + paddingRight);
            paddingLeft = jump * i + spaceBetweenBars;
            paddingRight = paddingRight + jump;
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
            wideSpace = wideSpace + 2;
        }
        return wideSpace;
    }
}
