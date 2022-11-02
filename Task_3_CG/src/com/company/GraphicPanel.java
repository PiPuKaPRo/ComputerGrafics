package com.company;

import javax.swing.*;
import java.awt.*;

public class GraphicPanel extends JPanel {
    private Color graphicColor = Color.GREEN;
    private int width;
    private int height;
    private String e = null;

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
            g.setColor(graphicColor); // устанавливаем цвет графика
            for(int x = 0; x < width; x++){           // делаем цикл с левой стороны экрана до правой
                double y = FunctionParser.retY(e ,x);  // переводим значение синуса в координату нашей системы
                g.drawOval(x, (int) y, 2, 2);   // рисуем кружок в этой точке
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