package com.company.VichisleniaAndPreobr;

import com.company.WindowAndFigures.AllTransform;

public class Moving extends AllTransform {
    public Moving(double deltaX, double deltaY) {
        super(new MatrixVichsl(new double[][] {
                {1, 0, 0},
                {0, 1, 0},
                {deltaX, deltaY, 1}
        }));
    }
}
