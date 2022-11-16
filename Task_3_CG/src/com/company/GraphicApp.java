package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GraphicApp{
    private JFrame frame;
    private JLabel statusLabel;
    private JTextField paramTextField;
    private JTextField nameTextField;
    private GraphicPanel graphicPanel;
    private Container mainContainer;
    private JButton bezierButton;
    List<Point> points = new ArrayList<>();
    private JPanel GraphicPanel;
    private double cof;

    public GraphicApp() {
        createFrame();
        initElements();
        this.cof = 1;
    }

    public GraphicApp(double cof) {
        this.cof = cof;
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

        paramTextField = new JTextField("0");
        paramTextField.setMaximumSize(new Dimension(300, 30));
        panel.add(paramTextField);

        panel.add(Box.createVerticalGlue());

        JButton button = new JButton("Нарисовать");
        panel.add(button);

        JButton down = new JButton("-");
        panel.add(down);

        JButton up = new JButton("+");
        panel.add(up);

        button.addActionListener(e -> {
            graphicPanel.setCof(cof);
            String expression = nameTextField.getText();
            graphicPanel.setExpression(expression);
            graphicPanel.repaint();
        });

        up.addActionListener(e -> {
            cof *=0.7;
            graphicPanel.setCof(cof);
            String expression = nameTextField.getText();
            graphicPanel.setExpression(expression);
            graphicPanel.repaint();
        });

        down.addActionListener(e -> {
            cof/=0.7;
            graphicPanel.setCof(cof);
            String expression = nameTextField.getText();
            graphicPanel.setExpression(expression);
            graphicPanel.repaint();
        });

        panel.add(down);
        panel.add(up);
        panel.add(button);
        return panel;
    }
}