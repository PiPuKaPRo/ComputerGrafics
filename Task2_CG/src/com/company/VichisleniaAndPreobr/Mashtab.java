package com.company.VichisleniaAndPreobr;

import com.company.WindowAndFigures.AllTransform;

public class Mashtab extends AllTransform {
    public Mashtab(double umenshCoef) {
        super(new MatrixVichsl(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, umenshCoef}
        }));
    }
}
