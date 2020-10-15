package com.netcracker.homework.one;

public class MyPoint {

    private int x;
    private int y;

    public MyPoint() {
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double[] getXY() {
        double[] xyArray = {x, y};
        return xyArray;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(double x, double y) {
        return Math.sqrt(Math.pow((getX() - x), 2) + Math.pow((getY() - y), 2));
    }

    public double getDistance(MyPoint anotherPoint) {
        return Math.sqrt(Math.pow((getX() - anotherPoint.getX()), 2)
                + Math.pow((getY() - anotherPoint.getY()), 2));
    }


    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(o == null || !(o instanceof MyPoint)) {
            return false;
        }
        MyPoint p = (MyPoint)o;
        return p.x == x && p.y == y;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "MyPoint{" +
                "x = " + getX() +
                ", y = " + getY() +
                '}';
    }
}
