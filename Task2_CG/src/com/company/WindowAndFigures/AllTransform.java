package com.company.WindowAndFigures;

import com.company.VichisleniaAndPreobr.MatrixVichsl;

public class AllTransform {
    private final MatrixVichsl transformation;


    public AllTransform(MatrixVichsl transformation) {
        this.transformation = transformation;
    }

    public MatrixVichsl getTransformation() {
        return transformation;
    }

    public AllTransform then(AllTransform t) {
        return new AllTransform(transformation.umnoz(t.getTransformation()));
    }

    public AllTransform getRedo() {
        MatrixVichsl inverse = transformation.invert();
        return new AllTransform(inverse);
    }
}
