package com.netcracker.homework.one;

public class MyRectangle {

    private int length = 0;
    private int width = 0;

    public MyRectangle() {
    }

    public MyRectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }

    public double getArea() {
        return length * width;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(o == null || !(o instanceof MyRectangle)){
            return false;
        }
        MyRectangle rec = (MyRectangle) o;
        return rec.length == length && rec.width == width;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + length;
        result = 31 * result + width;
        return result;
    }

    @Override
    public String toString() {
        return "Rectangle[length = " + getLength()
                + ", width = " + getWidth() + "]";
    }
}
