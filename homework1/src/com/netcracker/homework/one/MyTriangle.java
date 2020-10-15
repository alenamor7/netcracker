package com.netcracker.homework.one;

public class MyTriangle {

    private MyPoint pointOne = new MyPoint();
    private MyPoint pointTwo = new MyPoint();
    private MyPoint pointThree = new MyPoint();

    public MyTriangle() {
    }

    public MyTriangle(MyPoint pointOne, MyPoint pointTwo, MyPoint pointThree) {
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
        this.pointThree = pointThree;
    }

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.pointOne = new MyPoint(x1, y1);
        this.pointTwo = new MyPoint(x2, y2);
        this.pointThree = new MyPoint(x3, y3);
    }

    public MyPoint getPointOne() {
        return pointOne;
    }

    public void setPointOne(MyPoint pointOne) {
        this.pointOne = pointOne;
    }

    public MyPoint getPointTwo() {
        return pointTwo;
    }

    public void setPointTwo(MyPoint pointTwo) {
        this.pointTwo = pointTwo;
    }

    public MyPoint getPointThree() {
        return pointThree;
    }

    public void setPointThree(MyPoint pointThree) {
        this.pointThree = pointThree;
    }

    public double getPerimeter() {
        return getPointOne().getDistance(getPointTwo())
                + getPointTwo().getDistance(getPointThree())
                + getPointThree().getDistance(getPointOne());
    }

    public double getArea() {
        double halfPerimeter = getPerimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - getPointOne().getDistance(getPointTwo())) *
                (halfPerimeter - getPointTwo().getDistance(getPointThree())) *
                halfPerimeter - getPointThree().getDistance(getPointOne()));
    }

    public String getType() {
        double sideOne = getPointOne().getDistance(getPointTwo());
        double sideTwo = getPointTwo().getDistance(getPointThree());
        double sideThree = getPointThree().getDistance(getPointOne());

        if(sideOne == sideTwo && sideTwo == sideThree) {
            return "Equilaterial";
        } else if(sideOne == sideTwo || sideTwo == sideThree || sideOne == sideThree) {
            return "Isosceles";
        }
        return "Scalene";
    }


    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(o == null || !(o instanceof MyTriangle)) {
            return false;
        }
        MyTriangle tr = (MyTriangle)o;
        return pointOne.equals(tr.pointOne)
                && pointTwo.equals(tr.pointTwo)
                && pointThree.equals(tr.pointThree);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + pointOne.hashCode();
        result = 31 * result + pointTwo.hashCode();
        result = 31 * result + pointThree.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MyTriangle[v1 = " + getPointOne().toString() +
                ", v2 = "+ getPointTwo().toString() +
                ", v3= "+ getPointThree().toString() + "]";
    }
}
