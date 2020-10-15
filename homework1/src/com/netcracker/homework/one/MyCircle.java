package com.netcracker.homework.one;

public class MyCircle {

    private int radius = 0;
    private String colour = "default red";

    public MyCircle() {
    }

    public MyCircle(int radius, String colour) {
        this.radius = radius;
        this.colour = colour;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    double getPerimeter() {
        return 2 * Math.PI * getRadius();
    }

    double getArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(o == null || !(o instanceof MyCircle)){
            return false;
        }
        MyCircle circle = (MyCircle) o;
        return circle.radius == radius && circle.colour.equals(colour);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + colour.hashCode();
        result = 31 * result + radius;
        return result;
    }


    @Override
    public String toString() {
        return "MyCircle {" +
                "radius = " + getRadius() +
                ", colour = '" + getColour() + '\'' +
                '}';
    }
}
