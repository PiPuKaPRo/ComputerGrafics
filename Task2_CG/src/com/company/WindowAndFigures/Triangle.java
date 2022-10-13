package com.company.WindowAndFigures;

public class Triangle extends Shape2d {

    public Triangle(
            OdnorodCoord2d point1,
            OdnorodCoord2d point2,
            OdnorodCoord2d point3
    ) {
        super();
        addVertex(point1);
        addVertex(point2);
        addVertex(point3);
    }

    public Triangle(
            double x1, double y1, double h1,
            double x2, double y2, double h2,
            double x3, double y3, double h3
    ) {
        super();
        addVertex(new OdnorodCoord2d(x1, y1, h1));
        addVertex(new OdnorodCoord2d(x2, y2, h2));
        addVertex(new OdnorodCoord2d(x3, y3, h3));
    }
}
