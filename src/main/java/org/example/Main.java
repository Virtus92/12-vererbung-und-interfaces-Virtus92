package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle("A", true, 12));
//        shapes.add(new Circle("A", true, -12));
        shapes.add(new Rectangle("B", true, 20, 30));
//        shapes.add(new Rectangle("B", true, -20, -30));
//        shapes.add(new Rectangle("B", true, -20, 30));
        shapes.add(new Square("C", false, 20));
//        shapes.add(new Square("C", false, -20));

        List<Double> results = new ArrayList<>();
        for (Shape shape : shapes) {
            results.add(shape.getArea());
            results.add(shape.getPerimeter());
        }

        System.out.println(results);
    }
}