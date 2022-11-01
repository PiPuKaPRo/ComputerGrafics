package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicApp {
    private JFrame frame;
    private JLabel statusLabel;
    private JTextField paramTextField;
    private JTextField nameTextField;
    private GraphicPanel graphicPanel;
    private  Container mainContainer;

    public GraphicApp(){
        createFrame();
        initElements();
    }

    private void createFrame() {
        frame = new JFrame("Графическое приложение");
        frame.setSize(1024, 1024);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void show(){
        frame.setVisible(true);
    }

    private void initElements() {
        mainContainer = frame.getContentPane();
        mainContainer.setLayout(new BorderLayout());

        JPanel bottomPanel = new JPanel(); // нижняя панель состояния
        bottomPanel.setBackground(Color.lightGray); // фон светло-серый
        mainContainer.add(bottomPanel, BorderLayout.SOUTH); // распологается внизу


        Box leftPanel = createLeftPanel(); // создаем левую панель в другом методе
        mainContainer.add(leftPanel, BorderLayout.WEST); // эта панель будет слева

        graphicPanel = new GraphicPanel();
        graphicPanel.setBackground(Color.WHITE);
        mainContainer.add(graphicPanel);
    }

    private Box createLeftPanel() {
        Box panel = Box.createVerticalBox();  // вертикальный Box
        // Box это контейнер, в котором элементы выстраиваются в одном порядке

        JLabel title = new JLabel("<html>Построение графика функции</html>");
        // чтобы добавить перевод строки в тексте, нужно писать в тегах <html>
        title.setFont(new Font(null, Font.BOLD, 12)); // изменяем шрифт
        panel.add(title);

        panel.add(Box.createVerticalStrut(20)); //в Box можно добавлять отступы

        panel.add(new JLabel("Функция:"));

        nameTextField = new JTextField();  // поле ввода названия
        nameTextField.setMaximumSize(new Dimension(300, 30)); // чтобы не был слишком большим
        panel.add(nameTextField);

        panel.add(new JLabel("Параметр:"));

        paramTextField = new JTextField("0");  // поле ввода с начальным текстом
        paramTextField.setMaximumSize(new Dimension(300, 30));
        panel.add(paramTextField);

        panel.add(Box.createVerticalGlue()); // также в Box можно добавлять заполнитель пустого места

        JButton button = new JButton("Нарисовать"); // Кнопка
        panel.add(button);

        JButton up = new JButton("Вверх"); // Кнопка
        panel.add(up);
        JButton down = new JButton("Вниз"); // Кнопка
        panel.add(down);
        JButton right = new JButton("Вправо"); // Кнопка
        panel.add(right);
        JButton left = new JButton("Влево"); // Кнопка
        panel.add(left);

        JButton bigger = new JButton("Увеличить"); // Кнопка
        panel.add(bigger);
        JButton smaller = new JButton("Уменьшить"); // Кнопка
        panel.add(smaller);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeGraphicColor();
            }
            private void changeGraphicColor(){
                String color = nameTextField.getText();
                graphicPanel.setNameAndColor(color);
            }
        });
        panel.add(button);
        return panel;



    }
}