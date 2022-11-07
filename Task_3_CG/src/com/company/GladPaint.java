package com.company;

import java.awt.*;

public class GladPaint{
    public static void drawLines(int x1, int y1, int x2, int y2, Graphics g){

        double dx,dy,steps,x,y,k;
        double xc,yc;
        dx=Math.abs(x2-x1);
        dy=Math.abs(y2-y1);
        steps = Math.max(Math.abs(dx), Math.abs(dy));
        xc=(dx/steps);
        yc=(dy/steps);
        x=x1;
        y=y1;
        for(k=1;k<=steps;k++)
        {
            x=x+xc;
            y=y+yc;
            plot((int)x,(int)y, g);
        }
    }

    private static void plot(int x, int y, Graphics g) {
        g.fillOval(x, y, 4, 4);
    }
}

