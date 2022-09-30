package com.company;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final Draw d;
    private int t;

    public MainWindow() throws HeadlessException{
        d = new Draw();
        this.add(d);

        int delay = 1000;
        Timer timer = new Timer(delay, e -> {
            t = (t + delay) % Integer.MAX_VALUE;
            d.updateTime(t);
            repaint();
        });
        timer.start();
    }
}
