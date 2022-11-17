package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class GraphicApp{
    private JFrame frame;
    private JLabel statusLabel;
    private JTextField paramTextField;
    private JTextField nameTextField;
    private GraphicPanel graphicPanel;
    private Container mainContainer;
    private JFrame GraphicPanel;
    private double cof;
    private double a;
    private int moveCof;
    private int moveCofY;

    public GraphicApp() {
        createFrame();
        initElements();
        this.cof = 1;
        this.moveCof = 0;
//        this.MouseAction = new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (e.getButton() == MouseEvent.BUTTON1) {
//                    if (keyPointNum < 4) {
//                        double x = e.getX();
//                        double y = e.getY();
//                        keyPointP[keyPointNum] = new Point2D.Double(x, y);
//                        keyPointE[keyPointNum] = new Ellipse2D.Double(x - 4, y - 4, 8, 8);
//                        keyPointNum++;
//                        graphicPanel.repaint();
//                    }
//                } // Щелкните правой кнопкой мыши
//                else if (e.getButton() == MouseEvent.BUTTON3) {
//                    flagShow = false; // скрыть силу синей помощи, но на самом деле не удаляет
//                    graphicPanel.repaint();
//                }
//            }
//        };
//        this.MouseMotion = new MouseMotionAdapter() {
//            @Override
//            public void mouseDragged(MouseEvent e) {
//                // Клавиша перетаскивания мыши
//                if (keyPointID != -1) {
//                    double x = e.getX();
//                    double y = e.getY();
//                    keyPointP[keyPointID] = new Point2D.Double(x, y);
//                    keyPointE[keyPointID] = new Ellipse2D.Double(x - 4, y - 4, 8, 8);
//                    graphicPanel.repaint();
//                }
//            }
//        };

    }

    private void createFrame() {
        frame = new JFrame("Графическое приложение");
        frame.setSize(1024, 1024);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void show() {
        frame.setVisible(true);
    }

    private void initElements() {
        mainContainer = frame.getContentPane();
        mainContainer.setLayout(new BorderLayout());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.lightGray);
        mainContainer.add(bottomPanel, BorderLayout.SOUTH);


        Box leftPanel = createLeftPanel();
        mainContainer.add(leftPanel, BorderLayout.WEST);

        graphicPanel = new GraphicPanel();
        graphicPanel.setBackground(Color.WHITE);
        mainContainer.add(graphicPanel);

    }


    private Box createLeftPanel() {
        Box panel = Box.createVerticalBox();


        JLabel title = new JLabel("<html>Построение графика функции</html>");
        title.setFont(new Font(null, Font.BOLD, 12));
        panel.add(title);

        panel.add(Box.createVerticalStrut(20));

        panel.add(new JLabel("Функция:"));

        nameTextField = new JTextField();
        nameTextField.setMaximumSize(new Dimension(300, 30));
        panel.add(nameTextField);

        panel.add(new JLabel("Параметр:"));

        paramTextField = new JTextField("1");
        paramTextField.setMaximumSize(new Dimension(300, 30));
        panel.add(paramTextField);

        panel.add(Box.createVerticalGlue());

        JButton button = new JButton("Нарисовать");
        panel.add(button);

        JButton minus = new JButton("-");
        panel.add(minus);

        JButton plus = new JButton("+");
        panel.add(plus);

        JButton left = new JButton("<-");
        panel.add(left);

        JButton right = new JButton("->");
        panel.add(right);

        JButton up = new JButton("^");
        panel.add(up);

        JButton down = new JButton("v");
        panel.add(down);


        button.addActionListener(e -> {
            graphicPanel.setCof(cof,moveCof,moveCofY);
            graphicPanel.setA(Double.parseDouble(paramTextField.getText()));
            String expression = nameTextField.getText();
            graphicPanel.setExpression(expression);
            graphicPanel.repaint();
        });

        plus.addActionListener(e -> {
            cof *=0.7;
            graphicPanel.setCof(cof,moveCof,moveCofY);
            graphicPanel.setA(Double.parseDouble(paramTextField.getText()));
            String expression = nameTextField.getText();
            graphicPanel.setExpression(expression);
            graphicPanel.repaint();
        });

        minus.addActionListener(e -> {
            cof/=0.7;
            graphicPanel.setCof(cof,moveCof,moveCofY);
            graphicPanel.setA(Double.parseDouble(paramTextField.getText()));
            String expression = nameTextField.getText();
            graphicPanel.setExpression(expression);
            graphicPanel.repaint();
        });

        left.addActionListener(e -> {
            moveCof+=30;
            graphicPanel.setCof(cof,moveCof,moveCofY);
            graphicPanel.setA(Double.parseDouble(paramTextField.getText()));
            String expression = nameTextField.getText();
            graphicPanel.setExpression(expression);
            graphicPanel.repaint();
        });

        right.addActionListener(e -> {
            moveCof-=30;
            graphicPanel.setCof(cof,moveCof,moveCofY);
            graphicPanel.setA(Double.parseDouble(paramTextField.getText()));
            String expression = nameTextField.getText();
            graphicPanel.setExpression(expression);
            graphicPanel.repaint();
        });

        up.addActionListener(e -> {
            moveCofY-=30;
            graphicPanel.setCof(cof,moveCof,moveCofY);
            graphicPanel.setA(Double.parseDouble(paramTextField.getText()));
            String expression = nameTextField.getText();
            graphicPanel.setExpression(expression);
            graphicPanel.repaint();
        });

        down.addActionListener(e -> {
            moveCofY+=30;
            graphicPanel.setCof(cof,moveCof,moveCofY);
            graphicPanel.setA(Double.parseDouble(paramTextField.getText()));
            String expression = nameTextField.getText();
            graphicPanel.setExpression(expression);
            graphicPanel.repaint();
        });

        panel.add(left);
        panel.add(right);
        panel.add(up);
        panel.add(down);
        panel.add(minus);
        panel.add(plus);
        panel.add(button);
        return panel;
    }
}