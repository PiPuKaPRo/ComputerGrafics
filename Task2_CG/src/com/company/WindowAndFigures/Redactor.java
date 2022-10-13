package com.company.WindowAndFigures;

import com.company.VichisleniaAndPreobr.Moving;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Redactor {
    private Shape2d current, preview;
    private OdnorodCoord2d transformOrigin;
    private Map<String, Shape2d> availableShapes;
    private Stack<AllTransform> selectedTransformations;

    public Redactor() {
        current = null;
        preview = null;
        transformOrigin = new OdnorodCoord2d(0, 0, 1);

        availableShapes = new HashMap<>();
        availableShapes.put("Прямоугольник", new Rectangle(0, 0, 1, 100, 50));
        availableShapes.put("Треугольник", new Triangle(0, 0, 1, 100, 0, 1, 50, 100, 1));

        selectedTransformations = new Stack<>();
    }

    public Shape2d getCurrent() {
        return current;
    }

    public void setCurrent(String shapeName) {
        this.current = availableShapes.get(shapeName).clone();
        this.preview = null;
    }

    public Shape2d getPreview() {
        return preview;
    }

    public void setPreview(Shape2d preview) {
        this.preview = preview;
    }

    public Map<String, Shape2d> getAvailableShapes() {
        return availableShapes;
    }

    public void addTransformation(AllTransform t) {
        Moving t1 = new Moving(-transformOrigin.getX(), -transformOrigin.getY()),
                t2 = new Moving(transformOrigin.getX(), transformOrigin.getY());
        AllTransform relativeTransform = t1.then(t).then(t2);
        selectedTransformations.push(relativeTransform);
        if (preview == null) {
            preview = new Path2d(current.getVertexes());
        }
        preview.transform(relativeTransform);
    }

    public void removeLastTransformation() {
        if (selectedTransformations.isEmpty() || preview == null) {
            return;
        }

        AllTransform t = selectedTransformations.pop();
        preview.transform(t.getRedo());

        if (selectedTransformations.isEmpty()) {
            preview = null;
        }
    }

    public void applyTransformations() {
        if (preview != null) {
            current = new Path2d(preview.getVertexes());
        }
        preview = null;
    }

    public void setTransformOrigin(OdnorodCoord2d coordinates2d) {
        transformOrigin = coordinates2d;
    }
}
