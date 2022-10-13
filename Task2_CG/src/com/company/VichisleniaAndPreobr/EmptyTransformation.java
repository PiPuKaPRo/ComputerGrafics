package com.company.VichisleniaAndPreobr;

import com.company.WindowAndFigures.AllTransform;

public class EmptyTransformation extends AllTransform {

    public EmptyTransformation() {
        super(new MatrixVichsl(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        }));
    }
}
