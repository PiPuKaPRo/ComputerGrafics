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
    private double a;
    private int moveCof;
    private int moveCofY;


    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        super.paint(g);
        width = getWidth();
        height = getHeight();

        drawGrid(g);
        drawAxis(g);
//        if (flagShow) {
//            for (int i = 0; i <keyPointNum; i ++) {// Нарисуйте точку
//                if (i > 0 && i < (keyPointNum - 1)) {
//                    g2.fill (keyPointE [i]); // Ключевые точки в середине
//                } else {
//                    g2.draw(keyPointE [i]); // Первая и последняя картина пустой круг
//                }
//                if (keyPointNum > 1 && i < (keyPointNum - 1)) {
//                    g.drawLine((int) keyPointP[i].getX(), (int) keyPointP[i].getY(), (int) keyPointP[i + 1].getX(),
//                            (int) keyPointP [i + 1] .getY());
//                }
//                if (i == 0) {
//                    g.drawString("A", (int) keyPointE[i].x, (int) keyPointE[i].y);
//                } else if (i == 1) {
//                    g.drawString("B", (int) keyPointE[i].x, (int) keyPointE[i].y);
//                } else if (i == 2) {
//                    g.drawString("C", (int) keyPointE[i].x, (int) keyPointE[i].y);
//                } else if (i == 3) {
//                    g.drawString("D", (int) keyPointE[i].x, (int) keyPointE[i].y);
//                }
//            }
//        }
//        // Вторая кривая Бетсесса
//        if (keyPointNum == 3) {
//            double x, y;
//            g.setColor(Color.RED);
//            for (double k = t; k <= 1 + t; k += t) {
//                double r = 1 - k;
//                x = Math.pow(r, 2) * keyPointP[0].getX() + 2 * k * r * keyPointP[1].getX() + Math.pow(k, 2) * keyPointP[2].getX();
//                y = Math.pow(r, 2) * keyPointP[0].getY() + 2 * k * r * keyPointP[1].getY() + Math.pow(k, 2) * keyPointP[2].getY();
//                g.drawOval ((int) x, (int) y, 1, 1); // Путь раундов лучше, чем рисунок следующего.
//                // g.drawLine((int) x, (int) y, (int) x, (int) y);
//            }
//        }
//        // Три кривых Бесселя
//        if (keyPointNum == 4) {
//            double x, y;
//            g.setColor(Color.RED);
//            for (double k = t; k <= 1 + t; k += t) {
//                double r = 1 - k;
//                x = Math.pow(r, 3) * keyPointP[0].getX() + 3 * k * Math.pow(r, 2) * keyPointP[1].getX()
//                        + 3 * Math.pow(k, 2) * (1 - k) * keyPointP[2].getX() + Math.pow(k, 3) * keyPointP[3].getX();
//                y = Math.pow(r, 3) * keyPointP[0].getY() + 3 * k * Math.pow(r, 2) * keyPointP[1].getY()
//                        + 3 * Math.pow(k, 2) * (1 - k) * keyPointP[2].getY() + Math.pow(k, 3) * keyPointP[3].getY();
//                g.drawOval((int) x, (int) y, 1, 1);
//            }
//        }
//
//
//        g2.setColor(Color.red);
//        for (Point p : points){
//            g2.fillOval((int) p.getX(), (int) p.getY(), 7, 7);
//        }


        if ((e != null) && a == 1) {
            g.setColor(graphicColor);
            double x = 0;
            double y = 0;
            for (double i = -50; i < 50; i += 0.0001) {
                x = a * (i * (1 / cof) * sizeOfGrid + width / 2 - 1.5) + moveCof;
                y = (-FunctionParser.retY(e, i) * sizeOfGrid + height / 2 - 5) - moveCofY;
                GladPaint.drawLines((int) x, (int) y, (int) (x + 1), (int) (y - 1), g);
                //drawXiaolinLine((int) x,(int) y,(int) (x+0.004),(int)(y-0.004),g);
            }
        } else if ((e != null)) {
            g.setColor(graphicColor);
            double x = 0;
            double y = 0;
            for (double i = -50; i < 50; i += 0.0001) {
                x = a * (i * (1 / cof) * sizeOfGrid + width / 2 - 1.5) + moveCof;
                y = (-FunctionParserWithParam.retY(e, i) * sizeOfGrid + height / 2 - 5) - moveCofY;
                GladPaint.drawLines((int) x, (int) y, (int) (x + 1), (int) (y - 1), g);
            }

        }
    }


    private void drawGrid(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);  //задаем серый цвет

        for (int x = width / 2 + + moveCof; x < width; x += 30) {  // цикл от центра до правого края
            g.drawLine(x, 0, x, height);    // вертикальная линия
        }

        for (int x = width / 2 + moveCof; x > 0; x -= 30) {  // цикл от центра до леваого края
            g.drawLine(x, 0, x, height);   // вертикальная линия
        }

        for (int y = height / 2 - moveCofY; y < height; y += 30) {  // цикл от центра до верхнего края
            g.drawLine(0, y, width, y);    // горизонтальная линия
        }

        for (int y = height / 2 - moveCofY; y > 0; y -= 30) {  // цикл от центра до леваого края
            g.drawLine(0, y, width, y);    // горизонтальная линия
        }
    }

    private void drawAxis(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(width / 2 + + moveCof, 0, width / 2 + + moveCof, height);
        g.drawLine(0, height / 2 - moveCofY, width, height / 2 - moveCofY);
    }

    public void setExpression(String e) {
        this.e = e;
    }

    public void setCof(double cof, int moveCof,int moveCofY) {
        this.cof = cof;
        this.moveCof = moveCof;
        this.moveCofY = moveCofY;
    }

    public void setA(double a) {
        this.a = a;
    }

}
