package org.example;

public class Rectangle extends Shape {
    private int length;
    private int width;

    public Rectangle(String color, Boolean isFilled, int length, int width) {
        super(color, isFilled);
        this.length = length;
        validate(length, "Length");
        validate(width, "Width");
        this.width = width;
    }

    @Override
    public double getArea() {
        return width*length;
    }

    @Override
    public double getPerimeter() {
        return width*2+length*2;
    }
}
