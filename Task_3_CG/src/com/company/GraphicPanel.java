package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GraphicPanel extends JPanel {
    private Color graphicColor = Color.RED;
    private int width;
    private int height;
    private String e = null;
    private double sizeOfGrid = 30;

    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
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
                drawXiaolinLine((int) x,(int) y,(int) (x+0.004),(int)(y-0.004),g);
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

    private float fractionalPart(float x) {
        int tmp = (int) x;
        return x - tmp; //вернёт дробную часть числа
    }

    private void drawXiaolinLine(int x1, int y1, int x2, int y2, Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        if (x2 < x1) {
            x1 += x2;
            x2 = x1 - x2;
            x1 -= x2;
            y1 += y2;
            y2 = y1 - y2;
            y1 -= y2;
        }
        int dx = x2 - x1;
        int dy = y2 - y1;
        //Если линия параллельна одной из осей, то не нужно как-то менять яркость
        if (dx == 0 || dy == 0) {
            g.setColor(Color.BLACK);
            g.drawLine(x1, y1, x2, y2);
            return;
        }
        float gradient = 0;
        if (dx > dy) {
            gradient = (float) dy / dx;
            float intery = y1 + gradient;
            g.setColor(Color.BLACK);
            g.drawLine(x1, y1, x1, y1);
            for (int x = x1; x < x2; ++x) {
                g.setColor(new Color(0, 0, 0, (int) (255 - fractionalPart(intery) * 255))); //Меняем яркость
                g.drawLine(x, (int)intery, x, (int)intery);
                g.setColor(new Color(0, 0, 0, (int) (fractionalPart(intery) * 255)));
                g.drawLine(x, (int)intery + 1, x, (int)intery + 1);
                intery += gradient;
            }
            g.setColor(Color.BLACK);
            g.drawLine(x2, y2, x2, y2);
        } else {
            gradient = (float) dx / dy;
            float interx = x1 + gradient;
            g.setColor(Color.BLACK);
            g.drawLine(x1, y1, x1, y1);
            for (int y = y1; y < y2; ++y) {
                g.setColor(new Color(0, 0, 0, (int) (255 - fractionalPart(interx) * 255)));
                g.drawLine((int)interx, y, (int)interx, y);
                g.setColor(new Color(0, 0, 0, (int) (fractionalPart(interx) * 255)));
                g.drawLine((int)interx + 1, y, (int)interx + 1, y);
                interx += gradient;
            }
            g.setColor(Color.BLACK);
            g.drawLine(x2, y2, x2, y2);
        }

    }
}