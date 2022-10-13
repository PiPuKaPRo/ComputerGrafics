package com.company.WindowAndFigures;

public class Point2d extends Shape2d {
    private int radius;

    public Point2d(double x, double y, double h, int radius) {
        super();
        addVertex(new OdnorodCoord2d(x, y, h));
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getX() {
        return getVertexes().get(0).getX();
    }

    public double getY() {
        return getVertexes().get(0).getY();
    }
}
