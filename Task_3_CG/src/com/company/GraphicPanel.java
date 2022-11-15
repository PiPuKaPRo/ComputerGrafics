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
    private static double cof;


    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        super.paint(g);
        width = getWidth(); // сохраняем текущую ширину панели
        height = getHeight(); // и высоту

        drawGrid(g); // рисуем сетку
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
        this.cof = 1;
    }

    public void setCof(double cof) {
        this.cof = cof;
    }


//    public void drawBezier(List<Point> points) {
//        Graphics2D g = (Graphics2D) this.getGraphics();
//        paint(g);
//        g.setStroke(new BasicStroke(3));
//        g.setColor(Color.BLUE);
//        int pointCount = points.size();
//        double[] xs = new double[pointCount];
//        double[] ys = new double[pointCount];
//        for (int i = 0; i < pointCount; i++) {
//            xs[i] = points.get(i).getX();
//            ys[i] = points.get(i).getY();
//        }
//        List<Integer> x = new ArrayList<>();
//        List<Integer> y = new ArrayList<>();
//        Casteljau alg = new Casteljau(xs, ys, pointCount);
//
//        if(pointCount > 1){
//            float t = 0;
//            while (t <= 1) {
//                Point temp = alg.getXYValues(t);
//                x.add(temp.x);
//                y.add(temp.y);
//                System.out.println(temp);
//                t += 0.01;
//            }
//        }
//        for (var i : points) {
//            g.fillOval(i.x, i.y,7, 7);
//        }
//        pointCount = x.size();
//        g.drawPolyline(x.stream().mapToInt(i->i).toArray(), y.stream().mapToInt(i->i).toArray(), pointCount);
//    }
//
//    private static void start(Graphics2D g) {
//        g.setColor(Color.white);
//        g.fillRect(0, 0, 1000, 1000);
//        g.setColor(Color.BLACK);
//        g.setStroke(new BasicStroke(1));
//        g.drawLine(500, 0, 500, 1000);
//        g.drawLine(0,500,1000, 500);
//        g.setColor(Color.GRAY);
//        for (int i = 0; i < 1001; i += 100) {
//            g.drawString(String.valueOf((i - 500) / cof), i, 10);
//            g.drawString(String.valueOf(((i - 500) / cof) * -1), 0, i);
//            g.drawLine(i, 0, i, 1000);
//            g.drawLine(0,i,1000, i);
//        }
//        g.setStroke(new BasicStroke(2));
//        g.setColor(Color.BLACK);
//        g.drawLine(500, 0, 500, 1000);
//        g.drawLine(0,500,1000, 500);
//        g.translate(500, 500);
//        g.rotate(Math.PI);
//        g.scale(-1,1);
//
//        g.setStroke(new BasicStroke(3));
//        g.setColor(Color.BLUE);
//    }
}
