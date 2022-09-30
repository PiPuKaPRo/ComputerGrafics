package com.company;

import java.awt.*;

public class Red {

    public void endPaint(Graphics2D g) {
        //hat
        //g.drawRect(310, 143,20,50);
        g.setColor(Color.yellow);
        g.fillRect(310, 143, 20, 50);
        g.drawLine(300, 193, 340, 193);


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
        g.setColor(Color.yellow);
        g.fillPolygon(pp);

        int[] Xx1 = {380, 393, 388};
        int[] Yy1 = {601, 660, 601};
        Polygon pp1 = new Polygon(Xx1, Yy1, 3);
        g.drawPolygon(pp1);
        g.setColor(Color.yellow);
        g.fillPolygon(pp1);

        int[] ayX = {320, 165, 475};
        int[] ayY = {200, 540, 540};
        Polygon py = new Polygon(ayX, ayY, 3);
        g.setColor(Color.black);
        g.drawPolygon(py);
        g.setColor(Color.red);
        g.fillPolygon(py);

        g.setColor(Color.black);
        g.fillOval(276, 344, 90, 70);

        //g.drawOval(276, 344, 10, 70);
        g.setColor(Color.white);
        g.fillOval(315, 347, 10, 60);

        g.setColor(Color.black);
        g.setColor(Color.red);
        g.fillOval(50, 50, 80, 80);


        g.setColor(Color.black);
        g.drawLine(278, 336, 286, 353);
        g.drawLine(305, 328, 306, 347);
        g.drawLine(360, 334, 355, 353);
        g.drawLine(338, 328, 335, 346);

        g.drawLine(286, 400, 278, 420);
        g.drawLine(306, 410, 305, 427);
        g.drawLine(355, 405, 360, 420);
        g.drawLine(335, 411, 338, 427);

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
        int[] Xс = {318, 270, 270, 366, 366};
        int[] Yс = {490, 470, 510, 470, 510};
        Polygon pс = new Polygon(Xс, Yс, 5);
        g.drawPolygon(pс);
        g.setColor(Color.black);
        g.fillPolygon(pс);


    }


}
