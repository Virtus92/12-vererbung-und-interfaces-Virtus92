package org.example;

public abstract class Shape {
    private String color;
    private Boolean isFilled;
    private int length;
    private int width;

    public Shape(String color, Boolean isFilled) {
        this.color = color;
        this.isFilled = isFilled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getIsFilled() {
        return isFilled;
    }

    public void setIsFilled(Boolean isFilled) {
        this.isFilled = isFilled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    protected void validate(double value, String fieldName) {
        if (value <=0) {
            throw new IllegalArgumentException(fieldName + " must be greater than 0.");
        }
    }
}
