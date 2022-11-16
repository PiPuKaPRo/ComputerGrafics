package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class GraphicPanel extends JPanel {
    private Color graphicColor = Color.RED;
    private int width;
    private int height;
    private String e = null;
    private double sizeOfGrid = 30;
    private double cof;


    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        super.paint(g);
        width = getWidth();
        height = getHeight();

        drawGrid(g);
        drawAxis(g);


        // рисуем оси
        if ((e != null)) {
            g.setColor(graphicColor);
            double x = 0;
            double y = 0;
            for (double i = -50; i < 50; i += 0.0001) {
                x = (i * (1/cof) * sizeOfGrid + width / 2 - 1.5);
                y = (-FunctionParser.retY(e, i) * sizeOfGrid + height / 2 - 5);
                GladPaint.drawLines((int) x, (int) y, (int) (x + 1), (int) (y - 1), g);
                //drawXiaolinLine((int) x,(int) y,(int) (x+0.004),(int)(y-0.004),g);
            }
        }
    }


    private void drawGrid(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);  //задаем серый цвет

        for (int x = width / 2; x < width; x += 30) {  // цикл от центра до правого края
            g.drawLine(x, 0, x, height);    // вертикальная линия
        }

        for (int x = width / 2; x > 0; x -= 30) {  // цикл от центра до леваого края
            g.drawLine(x, 0, x, height);   // вертикальная линия
        }

        for (int y = height / 2; y < height; y += 30) {  // цикл от центра до верхнего края
            g.drawLine(0, y, width, y);    // горизонтальная линия
        }

        for (int y = height / 2; y > 0; y -= 30) {  // цикл от центра до леваого края
            g.drawLine(0, y, width, y);    // горизонтальная линия
        }
    }

    private void drawAxis(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(width / 2, 0, width / 2, height);
        g.drawLine(0, height / 2, width, height / 2);
    }

    public void setExpression(String e) {
        this.e = e;
    }

    public void setCof(double cof) {
        this.cof = cof;
    }
}
