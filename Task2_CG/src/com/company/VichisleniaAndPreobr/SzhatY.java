package com.company.VichisleniaAndPreobr;

import com.company.WindowAndFigures.AllTransform;

public class SzhatY extends AllTransform {
    public SzhatY(double b) {
        super(new MatrixVichsl(new double[][]{
                {1, 0, 0},
                {0, b, 0},
                {0, 0, 1}
        }));
        if (b == 0) {
            throw new RuntimeException("Коэффициент увеличения не может равняться 0");
        }
    }
}
