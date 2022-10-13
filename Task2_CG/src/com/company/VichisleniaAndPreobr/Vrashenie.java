package com.company.VichisleniaAndPreobr;

import com.company.WindowAndFigures.AllTransform;

public class Vrashenie extends AllTransform {
    public Vrashenie(double teta) {
        super(new MatrixVichsl(new double[][]{
                {Math.cos(teta), -Math.sin(teta), 0},
                {Math.sin(teta), Math.cos(teta), 0},
                {0, 0, 1}
        }));
    }
}
