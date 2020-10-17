package com.netcracker.homework;

import java.util.Objects;

public class Complex implements Cloneable{
    private double real = 0.0;
    private double imag = 0.0;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public boolean isReal() {
        return real != 0 && imag == 0;
    }

    public boolean isImaginary() {
        return imag != 0 && real == 0;
    }

    public boolean equal(double anotherReal, double anotherImag) {
        return real == anotherReal && imag == anotherImag;
    }
    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    public double argument() {
        return Math.atan(imag / real);
    }

    /*
    * .add() method modifies(add new complex to) current object,
    * .addForNew() create new object by cloning, modify it and return it
     */
    public void add(Complex right) {
        this.real += right.real;
        this.imag += right.imag;
    }

    public Complex addForNew(Complex right) throws CloneNotSupportedException{
        Complex newComplex = this.clone();
        newComplex.setReal(this.real + right.real);
        newComplex.setImag(this.imag + right.imag);
        return newComplex;
    }

    /*
     * .substract() method modifies(substract from) current object,
     * .addForNew() create new object by cloning, modify it and return it
     */
    public void substract(Complex right) {
        this.real -= right.real;
        this.imag -= right.imag;
    }

    public Complex substractForNew(Complex right) throws CloneNotSupportedException{
        Complex newComplex = this.clone();
        newComplex.setReal(this.real - right.real);
        newComplex.setImag(this.imag - right.imag);
        return newComplex;
    }

    /*
     * .multiply() method modifies(multiply with) current object,
     * .multiplyForNew() create new object by cloning, modify it and return it
     */
    public void multiply(Complex right) {
        double oldReal = real;
        double oldImag = imag;
        this.real = oldReal * right.real - oldImag * right.imag;
        this.imag = oldReal * right.real + oldImag * right.imag;
    }

    public Complex multiplyForNew(Complex right) throws CloneNotSupportedException{
        Complex newComplex = this.clone();
        newComplex.setReal(this.real * right.real - this.imag * right.imag);
        newComplex.setImag(this.real * right.imag + right.real * this.imag);
        return newComplex;
    }

    /*
     * .divide() method modifies(divide) current object,
     * .divideForNew() create new object by cloning, modify it and return it
     */
    public void divide(Complex right) {
        double oldReal = real;
        double oldImag = imag;
        this.real = (oldReal * right.real + oldImag * right.imag) / (right.real * right.real + right.imag * right.imag);
        this.imag = (oldImag * right.real - oldReal * right.imag) / (right.real * right.real + right.imag * right.imag);
    }

    public Complex divideForNew(Complex right) throws CloneNotSupportedException{
        Complex newComplex = this.clone();
        newComplex.setReal((this.real * right.real + this.imag * right.imag) / (right.real * right.real + right.imag * right.imag));
        newComplex.setImag((this.imag * right.real - this.real * right.imag) / (right.real * right.real + right.imag * right.imag));
        return newComplex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Complex)) {
            return false;
        }
        Complex complex = (Complex) o;
        return real == complex.getReal() && imag == complex.getImag();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (int)(Double.doubleToLongBits(real)^(Double.doubleToLongBits(real) >>> 32));
        result = 31 * result + (int)(Double.doubleToLongBits(imag)^(Double.doubleToLongBits(imag) >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "real = " + getReal() +
                ", imag = " + getImag() +
                '}';
    }

    public Complex clone() throws CloneNotSupportedException {
        return (Complex) super.clone();
    }
}
