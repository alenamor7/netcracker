package com.netcracker.homework;

public class Main {
    public static void main(String[] args) {
        //test Ball class
        Ball firstBall = new Ball(1, 3, 3, 4, 45);
        System.out.println(firstBall.toString());
        firstBall.reflectHorizontal();
        firstBall.reflectVertical();
        System.out.println(firstBall.toString());
        firstBall.move();
        System.out.println(firstBall.toString());
        System.out.println();

        //test Complex class
        Complex firstComplex = new Complex(12.5, 43.4);
        Complex secondComplex = new Complex(3, 4);
        //let's add secondComplex to firstComplex using addForNew(returns new object, doesn't current one)
        try {
            Complex complexForAdd = firstComplex.addForNew(secondComplex);
            System.out.println("New objects after adding: " + complexForAdd.toString());
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone process is not supportable");
        }
        System.out.println("Old object after adding(shouldn't be modified): " + firstComplex.toString());
        //let's add secondComplex to firstComplex
        firstComplex.add(secondComplex);
        System.out.println("Old object was modified: " + firstComplex.toString());
        //test same with divide, for example
        try {
            Complex complexForDivide = firstComplex.divideForNew(secondComplex);
            System.out.println("New objects after dividing: " + complexForDivide.toString());
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone process is not supportable");
        }
        System.out.println("Old object after dividing(shouldn't be modified): " + firstComplex.toString());
        firstComplex.divide(secondComplex);
        System.out.println("Old object was modified: " + firstComplex.toString());
        System.out.println();

        //test Polynomial class
        Polynomial firstPolynomial = new Polynomial(1, 2, 3, 4, 5);
        Polynomial secondPolynomial = new Polynomial(6, 7, 8, 9, 10);
        System.out.println("Degree of polynomial: " + firstPolynomial.getDegree());
        System.out.println(firstPolynomial.add(secondPolynomial));
        System.out.println(firstPolynomial.multiply(secondPolynomial));
        System.out.println();

        //test Container class
        Container c1 = new Container(1,1, 5,4);
        System.out.println(c1.toString());
        Ball ball = new Ball(3, 3, 2, 3, 90);
        System.out.println(c1.collides(ball)); //must be true
        ball.move();
        System.out.println(c1.collides(ball)); //must be false after moving

    }
}
