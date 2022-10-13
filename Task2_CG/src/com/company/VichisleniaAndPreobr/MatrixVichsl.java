package com.company.VichisleniaAndPreobr;

import java.util.ArrayList;
import java.util.List;

public class MatrixVichsl {
    private final List<List<Double>> values;

    {
        this.values = new ArrayList<>();
    }

    public MatrixVichsl umnoz(MatrixVichsl m) {
        List<List<Double>> res = new ArrayList<>();
        for (List<Double> v : this.values) {
            List<Double> newRow = new ArrayList<>();
            res.add(newRow);
            for (int i = 0; i < m.getColNum(); i++) {
                double r = 0;
                for (int k = 0; k < m.getRNum(); k++) {
                    r += v.get(k) * m.getValue(k, i);
                }
                newRow.add(r);
            }
        }
        return new MatrixVichsl(res);
    }

    public double determ() {
        if (getColNum() == 1) {
            return values.get(0).get(0);
        }
        double d = 0;
        for (int i = 0; i < getColNum(); i++) {
            d += values.get(0).get(i) * AlgDop(0, i);
        }
        return d;
    }

    public double AlgDop(int i, int j) {
        return ((i + j) % 2 == 0 ? 1 : -1) * minor(i, j);
    }

    public double minor(int a, int b) {
        List<List<Double>> mVal = new ArrayList<>();
        for (int i = 0; i < getRNum(); i++) {
            if (i != a) {
                List<Double> minorRow = new ArrayList<>();
                for (int j = 0; j < getColNum(); j++) {
                    if (j != b) {
                        minorRow.add(values.get(i).get(j));
                    }
                }
                mVal.add(minorRow);
            }
        }
        return new MatrixVichsl(mVal).determ();
    }

    public MatrixVichsl transpon() {
        double[][] t = new double[getRNum()][getColNum()];
        for (int i = 0; i < getRNum(); i++) {
            for (int j = i; j < getColNum(); j++) {
                t[i][j] = values.get(j).get(i);
                t[j][i] = values.get(i).get(j);
            }
        }
        return new MatrixVichsl(t);
    }

    public MatrixVichsl invert() {
        double det = determ();
        if (det == 0) {
            throw new RuntimeException("На 0 делить нельзя(((");
        }
        List<List<Double>> res = new ArrayList<>();
        for (int i = 0; i < getRNum(); i++) {
            List<Double> row = new ArrayList<>();
            for (int j = 0; j < getColNum(); j++) {
                row.add(AlgDop(i, j) / det);
            }
            res.add(row);
        }

        return new MatrixVichsl(res).transpon();
    }



    public MatrixVichsl(List<List<Double>> values) {
        for (List<Double> row : values) {
            List<Double> r = new ArrayList<>();
            this.values.add(r);
            r.addAll(row);
        }
    }

    public MatrixVichsl(double[][] values) {
        for (double[] row : values) {
            List<Double> newRow = new ArrayList<>();
            this.values.add(newRow);
            for (Double value : row) {
                newRow.add(value);
            }
        }
    }

    public List<List<Double>> getValues() {
        return new ArrayList<>(values);
    }

    public double getValue(int i, int j) {
        return values.get(i).get(j);
    }

    public int getRNum() {
        return values.size();
    }

    public int getColNum() {
        return values.get(0).size();
    }
}
