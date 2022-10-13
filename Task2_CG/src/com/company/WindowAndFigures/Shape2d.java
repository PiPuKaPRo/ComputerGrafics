package com.company.WindowAndFigures;

import com.company.VichisleniaAndPreobr.MatrixVichsl;

import java.util.ArrayList;
import java.util.List;

abstract public class Shape2d implements Cloneable{
    private final List<OdnorodCoord2d> vertexes;
    public Shape2d() {
        this.vertexes = new ArrayList<>();
    }

    public Shape2d(List<OdnorodCoord2d> vertexes) {
        this.vertexes = new ArrayList<>(vertexes);
    }
    public List<OdnorodCoord2d> getVertexes() {
        return new ArrayList<>(vertexes);
    }

    public void addVertex(OdnorodCoord2d coordinates2d) {
        vertexes.add(coordinates2d);
    }

    public MatrixVichsl getMatrixVertexes() {
        List<List<Double>> coords = new ArrayList<>();
        for (OdnorodCoord2d vertex : vertexes) {
            coords.add(vertex.getValues());
        }
        return new MatrixVichsl(coords);
    }

    public void transform(AllTransform t) {
        MatrixVichsl transformedCoordinates = getMatrixVertexes().umnoz(t.getTransformation());
        int i = 0;
        for (List<Double> row : transformedCoordinates.getValues()) {
            vertexes.set(i++, new OdnorodCoord2d(row));
        }
    }

    @Override
    public Shape2d clone() {
        return new Path2d(vertexes);
    }
}
