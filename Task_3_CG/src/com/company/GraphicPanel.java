package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GraphicPanel extends JPanel {
    private Color graphicColor = Color.RED;
    private int width;
    private int height;
    private double startX;
    private double startY;
    private String e = null;
    private double sizeOfGrid = 30;

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        width = getWidth(); // сохраняем текущую ширину панели
        height = getHeight(); // и высоту

        drawGrid(g); // рисуем сетку
        drawAxis(g);



        // рисуем оси
        if (e != null) {
            g.setColor(graphicColor);
            double x = 0;
            double y = 0;
            for (double i = -150; i < 150; i+=0.004) {
                x = i * sizeOfGrid + width/2;
                y = -FunctionParser.retY(e, i) * sizeOfGrid + height/2;
                g.fillOval((int) x, (int) y, 5, 5);
            }
        }
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);  //задаем серый цвет

        for(int x=width/2; x<width; x+=30){  // цикл от центра до правого края
            g.drawLine(x, 0, x, height);    // вертикальная линия
        }

        for(int x=width/2; x>0; x-=30){  // цикл от центра до леваого края
            g.drawLine(x, 0, x, height);   // вертикальная линия
        }

        for(int y=height/2; y<height; y+=30){  // цикл от центра до верхнего края
            g.drawLine(0, y, width, y);    // горизонтальная линия
        }

        for(int y=height/2; y>0; y-=30){  // цикл от центра до леваого края
            g.drawLine(0, y, width, y);    // горизонтальная линия
        }
    }

    private void drawAxis(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(width/2, 0, width/2, height);
        g.drawLine(0, height/2, width, height/2);
    }

    public void setExpression(String e) {
        this.e = e;
    }

}