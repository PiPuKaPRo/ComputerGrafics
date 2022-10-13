package com.company.WindowAndFigures;

import java.util.ArrayList;
import java.util.List;

public class OdnorodCoord2d implements Cloneable {
    private final List<Double> values;

    public OdnorodCoord2d(double x, double y, double h) {
        values = new ArrayList<>();
        values.add(x);
        values.add(y);
        values.add(h);
    }

    public OdnorodCoord2d(List<Double> values) {
        this.values = new ArrayList<>();
        this.values.addAll(values);
    }

    public List<Double> getValues() {
        return new ArrayList<>(this.values);
    }

    public double getHomogeneousX() {
        return values.get(0);
    }

    public double getX() {
        return values.get(0) / values.get(2);
    }

    public void setHomogeneousX(double x) {
        values.set(0, x);
    }

    public double getHomogeneousY() {
        return values.get(1);
    }

    public double getY() {
        return values.get(1) / values.get(2);
    }

    public void setHomogeneousY(double y) {
        values.set(1, y);
    }

    public double getH() {
        return values.get(2);
    }

    public void setH(double h) {
        values.set(2, h);
    }

    @Override
    public OdnorodCoord2d clone() {
        return new OdnorodCoord2d(this.values);
    }
}
