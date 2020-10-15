package com.netcracker.homework.one;

public class Main {
    public static void main(String[] args) {
        Employee andy = new Employee("Andy", "Anderson", 4000);
        System.out.println(andy.toString());
        andy.raiseSalary(10);
        System.out.println(andy.toString());
        System.out.println("Andy has id: " + andy.getId());
        Employee kate = new Employee("Kate", "Austin", 5000);
        System.out.println("Kate has id: " + kate.getId());
        System.out.println("Kate's annual salary is " + kate.getAnnualSalary());

        MyPoint myFirstPoint = new MyPoint(1,4);
        MyPoint mySecondPoint = new MyPoint(10, 3);
        System.out.println("The distance between first and second points: " + myFirstPoint.getDistance(mySecondPoint));
        MyPoint myThirdPoint = new MyPoint(1,4);
        System.out.println("First and second points are equal: " + myFirstPoint.equals(mySecondPoint));
        System.out.println("First and third points are equal: " + myFirstPoint.equals(myThirdPoint));

        MyCircle myCircle = new MyCircle(4, "black");
        System.out.println("Area of circle with radius " + myCircle.getRadius() + " is: " + myCircle.getArea());
        System.out.println("Perimeter of circle with radius " + myCircle.getRadius() + " is: " + myCircle.getPerimeter());

        MyTriangle myFirstTriangle = new MyTriangle(1, 1, 3, 3, 2, 12);
        System.out.println("Perimeter of the triangle is: " + myFirstTriangle.getPerimeter());
        System.out.println("Area of the triangle is: " + myFirstTriangle.getArea());
        MyTriangle mySecondTriangle = new MyTriangle(new MyPoint(1,1), new MyPoint(3,3), new MyPoint(2, 12));
        System.out.println("My first and second triangles are equal: " + myFirstTriangle.equals(mySecondTriangle));

        MyRectangle myFirstRectangle = new MyRectangle(3, 4);
        System.out.println("The rectangle with width " + myFirstRectangle.getWidth()
                            + " and length " + myFirstRectangle.getLength()
                            + " has parameter " + myFirstRectangle.getPerimeter()
                            + " and area " + myFirstRectangle.getArea());
    }
}
