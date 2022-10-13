package com.company.VichisleniaAndPreobr;

import com.company.WindowAndFigures.AllTransform;

public class OtrazhY extends AllTransform {

    public OtrazhY() {
        super(new MatrixVichsl(new double[][]{
                {1, 0, 0},
                {0, -1, 0},
                {0, 0, 1}
        }));
    }
}
