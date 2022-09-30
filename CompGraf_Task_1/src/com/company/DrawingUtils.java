package com.company;

import java.awt.*;
import java.util.Random;

public class DrawingUtils {

    public static void startPaint(Graphics2D g) {
        g.setColor(Color.lightGray);
        g.fillOval(50, 50, 80, 80);

        int[] arrayX = {320, 165, 475};
        int[] arrayY = {200, 540, 540};
        Polygon poly = new Polygon(arrayX, arrayY, 3);
        g.setColor(Color.black);
        g.drawPolygon(poly);
        g.setColor(Color.yellow);
        g.fillPolygon(poly);

        //параллел горизонт линии
        g.setColor(Color.black);
        g.drawLine(203, 460, 437, 460);
        g.drawLine(188, 490, 450, 490);
        g.drawLine(175, 520, 465, 520);

        //кирпичики
        g.drawLine(240, 460, 240, 490);
        g.drawLine(395, 460, 395, 490);
        g.drawLine(318, 490, 318, 520);
        g.drawLine(217, 490, 217, 520);
        g.drawLine(420, 490, 420, 520);
        g.drawLine(268, 520, 268, 540);
        g.drawLine(369, 520, 369, 540);


        //бабочка))
        int[] X = {318, 270, 270, 366, 366};
        int[] Y = {490, 470, 510, 470, 510};
        Polygon p = new Polygon(X, Y, 5);
        g.drawPolygon(p);
        g.setColor(Color.black);
        g.fillPolygon(p);


        //eye
        g.drawOval(276, 344, 90, 70);

        g.drawLine(278, 336, 286, 353);
        g.drawLine(305, 328, 306, 347);
        g.drawLine(360, 334, 355, 353);
        g.drawLine(338, 328, 335, 346);

        g.drawLine(286, 400, 278, 420);
        g.drawLine(306, 410, 305, 427);
        g.drawLine(355, 405, 360, 420);
        g.drawLine(335, 411, 338, 427);


        //g.drawOval(276, 344, 10, 70);
        g.setColor(Color.black);
        g.fillOval(315, 347, 10, 60);
    }

    public static void paintBackGround(Graphics2D g){
        //пейзаж сзади
        int[] arr = {100, 240, 300, 750};
        int[] arra = {1000, 490, 490, 1000};
        Polygon ply = new Polygon(arr, arra, 4);
        g.drawPolygon(ply);
        g.setColor(Color.pink);
        g.fillPolygon(ply);


        g.setColor(Color.orange);
        g.fillRect(110, 500, 50, 100);

        int[] r = {-30, 300, 135};
        int[] ra = {540, 540, 460};
        Polygon iop = new Polygon(r, ra, 3);
        g.setColor(Color.green);
        g.drawPolygon(iop);
        g.setColor(Color.green);
        g.fillPolygon(iop);

        int[] ew = {10, 240, 135};
        int[] ewq = {460, 460, 380};
        Polygon asd = new Polygon(ew, ewq, 3);
        g.drawPolygon(asd);
        g.setColor(Color.green);
        g.fillPolygon(asd);

        int[] rty = {30, 225, 135};
        int[] rt = {380, 380, 280};
        Polygon cvb = new Polygon(rty, rt, 3);
        g.drawPolygon(cvb);
        g.setColor(Color.green);
        g.fillPolygon(cvb);

        g.setColor(Color.orange);
        g.fillRect(500, 460, 50, 100);


        int[] r1 = {390, 660, 525};
        int[] ra1 = {520, 520, 400};
        Polygon io1p = new Polygon(r1, ra1, 3);
        g.setColor(Color.green);
        g.drawPolygon(io1p);
        g.setColor(Color.green);
        g.fillPolygon(io1p);

        int[] ew1 = {420, 630, 525};
        int[] ewq1 = {410, 410, 280};
        Polygon asd1 = new Polygon(ew1, ewq1, 3);
        g.drawPolygon(asd1);
        g.setColor(Color.green);
        g.fillPolygon(asd1);

        int[] rty1 = {440, 610, 525};
        int[] rt1 = {290, 290, 150};
        Polygon cvb1 = new Polygon(rty1, rt1, 3);
        g.drawPolygon(cvb1);
        g.setColor(Color.green);
        g.fillPolygon(cvb1);
        g.setColor(Color.black);



        //конечности
        //arms
        g.drawArc(345, 340, 150, 70, 270, 100);
        g.drawArc(148, 340, 150, 70, 180, 90);

        g.drawOval(490, 366, 10, 10);
        g.drawOval(144, 370, 10, 10);
        g.drawArc(133, 358, 30, 20, 270, 100);
        g.drawArc(484, 356, 30, 20, 270, 100);
        g.drawArc(129, 358, 30, 20, 180, 90);
        g.drawArc(480, 356, 30, 20, 180, 90);
        g.drawArc(133, 358, 30, 20, 270, 100);

        g.drawArc(139, 319, 55, 60, 200, 20);
        g.drawArc(123, 358, 30, 30, 270, 90);


        g.drawArc(472, 350, 30, 20, 280, 90);
        g.drawArc(493, 363, 30, 20, 190, 100);


        //legs
        g.drawArc(237, 540, 50, 70, 100, 140);
        g.drawArc(350, 540, 50, 70, 295, 140);
        g.drawOval(244, 601, 10, 10);
        g.drawOval(380, 601, 10, 10);
        int[] Xx = {245, 240, 253};
        int[] Yy = {601, 660, 601};
        Polygon pp = new Polygon(Xx, Yy, 3);
        g.drawPolygon(pp);
        g.setColor(Color.black);
        g.fillPolygon(pp);

        int[] Xx1 = {380, 393, 388};
        int[] Yy1 = {601, 660, 601};
        Polygon pp1 = new Polygon(Xx1, Yy1, 3);
        g.drawPolygon(pp1);
        g.setColor(Color.black);
        g.fillPolygon(pp1);


        //hat
        //g.drawRect(310, 143,20,50);
        g.setColor(Color.black);
        g.fillRect(310, 143, 20, 50);
        g.drawLine(300, 193, 340, 193);
    }

    public static void stars(Graphics2D g){
            Random random = new Random();
            int x;
            int y;
            for (int i = 0; i < 16; i++) {
                x = random.nextInt(700);
                y = random.nextInt(200);
                g.setColor(Color.yellow);
                g.fillOval(x, y, 5, 5);
            }

    }
}
