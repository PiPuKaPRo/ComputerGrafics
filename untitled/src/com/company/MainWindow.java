package com.company;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;

public class MainWindow extends JFrame{
    private JButton uploadButton;
    private JButton saveButton;
    private JButton createButton;
    private JPanel panel1;
    private JLabel lable1;
    private JLabel lable2;
    private Compressor c;

    public BufferedImage image;
    ByteArrayOutputStream baos;


    public MainWindow() throws IOException {
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        final JFileChooser f = new JFileChooser();



        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                f.setCurrentDirectory(new File("C:\\Users\\Евген\\Desktop\\untitled\\"));
                f.showDialog(MainWindow.this, "Открыть");
                try {
                    image = ImageIO.read(f.getSelectedFile());
                    baos = new ByteArrayOutputStream(1000);
                    ImageIO.write(image, "jpg", baos);
                    baos.flush();
                    baos.close();
                    lable1.setIcon(new ImageIcon(image));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                byte[] bytes = baos.toByteArray();
                c = new Compressor();
                Decompressor d = new Decompressor();
                try {
                    bytes = d.decompress(c.compress(bytes));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println(Arrays.toString(bytes));
                    System.out.println(new ByteArrayInputStream(bytes));
                    lable2.setIcon(new ImageIcon(ImageIO.read(new ByteArrayInputStream(bytes))));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("C:\\Users\\Евген\\Desktop\\untitled\\"));

                fileChooser.setName("result");

                fileChooser.showDialog(MainWindow.this,"Save");

                fileChooser.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        return f.getName().toLowerCase().endsWith(".bin");
                    }

                    @Override
                    public String getDescription() {
                        return ".bin";
                    }
                });

                File file = fileChooser.getSelectedFile();

                try {
                    Writer w = new FileWriter(file);
                    w.write(new String(c.getArray(), "UTF-32").toCharArray());
                    w.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
