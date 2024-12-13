package org.example;

public class Circle extends Shape{
    private int radius;

    public Circle(String color, Boolean isFilled, int radius) {
        super(color, isFilled);
        validate(radius, "Radius");
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return (radius*2)*Math.PI;
    }
}
