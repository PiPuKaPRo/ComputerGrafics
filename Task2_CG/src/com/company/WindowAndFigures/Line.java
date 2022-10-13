package com.company.WindowAndFigures;

public class Line extends Shape2d {
    public Line(
            double x1, double y1, double h1,
            double x2, double y2, double h2
    ) {
        super();
        addVertex(new OdnorodCoord2d(x1, y1, h1));
        addVertex(new OdnorodCoord2d(x2, y2, h2));
    }

    public Line(OdnorodCoord2d point1, OdnorodCoord2d point2) {
        super();
        addVertex(point1);
        addVertex(point2);
    }
}
