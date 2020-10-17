package com.netcracker.homework;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x1, int y1, int width, int height) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1 + width;
        this.y2 = y1 + height;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void getWidth() {
    }

    public boolean collides(Ball ball) {
        if((ball.getX() - ball.getRadius()) >= x1 && (ball.getX() + ball.getRadius()) <= x2 &&
                (ball.getY() - ball.getRadius()) >= y1 && (ball.getY() + ball.getRadius()) <= y2){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Container[(" + x1 + "," + y1 + "), (" + y1 + "," + y2 + ")]";
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof Container)){
            return true;
        }
        Container cont = (Container)o;
        return cont.x1 == x1 && cont.y1 == y1 && cont.y1 == y1 && cont.y2 == y2;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 31*result + x1;
        result = 31*result + y1;
        result = 31*result + y1;
        result = 31*result + y2;
        return result;
    }

}
