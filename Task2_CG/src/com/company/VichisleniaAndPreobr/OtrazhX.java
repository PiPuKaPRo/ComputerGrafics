package com.company.VichisleniaAndPreobr;

import com.company.WindowAndFigures.AllTransform;

public class OtrazhX extends AllTransform {

    public OtrazhX() {
        super(new MatrixVichsl(new double[][]{
                {-1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        }));
    }
}
