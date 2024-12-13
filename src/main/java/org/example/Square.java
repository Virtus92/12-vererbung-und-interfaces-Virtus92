package org.example;

public class Square extends Shape {
    private int length;

    public Square(String color, Boolean isFilled, int length) {
        super(color, isFilled);
        validate(length, "Length");
        this.length = length;
    }

    @Override
    public double getArea() {
        return length*length;
    }

    @Override
    public double getPerimeter() {
        return length*4;
    }
}
