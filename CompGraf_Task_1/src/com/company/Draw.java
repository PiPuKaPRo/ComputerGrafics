package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Draw extends JPanel {
    public static final int ANIMATION_DELAY = 5000;
    public static final int ANIMATION_GAP = 5000;
    private int time;

    public Draw() {
        this.time = 0;
    }

    @Override
    public void paint(Graphics gr) {
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;
        setBackground(Color.blue);
        DrawingUtils.stars(g);
        g.setStroke(new BasicStroke(5f));
        if (time >= 5000) {
            DrawingUtils.stars(g);
        }
        DrawingUtils.paintBackGround(g);
        DrawingUtils.startPaint(g);
        if (time >= 5000) {
            new Red().endPaint(g);
        }
    }

    public void updateTime(int time) {
        this.time = time % (ANIMATION_DELAY + ANIMATION_GAP);
    }
}
