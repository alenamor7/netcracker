package com.netcracker.homework;

import java.util.Objects;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta =(float)(speed * Math.cos(direction));
        this.yDelta = (float)(-speed * Math.sin(direction));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getXDelta() {
        return xDelta;
    }

    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getYDelta() {
        return yDelta;
    }

    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        x += xDelta;
        y += yDelta;
    }

    public void reflectHorizontal() {
        xDelta = - xDelta;
    }

    public void reflectVertical() {
        yDelta = - yDelta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof  Ball)) {
            return false;
        }
        Ball ball = (Ball) o;
        return x == ball.getX() && y == ball.getY()
                && radius == ball.getRadius()
                && xDelta == ball.getXDelta() && yDelta == ball.getYDelta();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + radius;
        result = 31 * result + Float.floatToIntBits(x);
        result = 31 * result + Float.floatToIntBits(y);
        result = 31 * result + Float.floatToIntBits(xDelta);
        result = 31 * result + Float.floatToIntBits(yDelta);
        return result;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", radius=" + getRadius() +
                ", speed = (" + getXDelta() + ", " + getYDelta() + ")};";
    }
}
