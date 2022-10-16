package com.company.VichisleniaAndPreobr;

import com.company.WindowAndFigures.AllTransform;

public class SzhatX extends AllTransform {
    public SzhatX(double a) {
        super(new MatrixVichsl(new double[][]{
                {a, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        }));
        if (a == 0) {
            throw new RuntimeException("Коэффициент увеличения не может равняться 0");
        }
    }
}