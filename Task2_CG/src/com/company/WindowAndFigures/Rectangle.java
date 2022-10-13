package com.company.WindowAndFigures;

public class Rectangle extends Shape2d {
    public Rectangle(double x, double y, double h, double width, double height) {
        super();
        addVertex(new OdnorodCoord2d(x, y, h));
        addVertex(new OdnorodCoord2d(x + width, y, h));
        addVertex(new OdnorodCoord2d(x + width, y + height, h));
        addVertex(new OdnorodCoord2d(x, y + height, h));
    }


}
