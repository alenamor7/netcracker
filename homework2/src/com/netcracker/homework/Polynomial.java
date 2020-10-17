package com.netcracker.homework;

import java.util.Arrays;

public class Polynomial {
    private int[] coeffs;

    public Polynomial(int... coeffs) {
        this.coeffs = coeffs;
    }

    public int[] getCoeffs() {
        return coeffs;
    }

    public void setCoeffs(int[] coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    public Polynomial add(Polynomial right) {
        int[] resCoeffs;
        if(coeffs.length > right.coeffs.length){  //length of resulting array depends on which array(this or right) is bigger
            resCoeffs = new int[coeffs.length];
            for(int i = 0; i < right.coeffs.length; i++) {
                resCoeffs[i] = right.coeffs[i] + coeffs[i];
            }
            for(int j = right.coeffs.length; j < coeffs.length; j++){
                resCoeffs[j] = coeffs[j];
            }
        } else {
            resCoeffs = new int[right.coeffs.length];
            for(int i = 0; i < coeffs.length; i++) {
                resCoeffs[i] = right.coeffs[i] + coeffs[i];
            }
            for(int j = coeffs.length; j < right.coeffs.length; j++){
                resCoeffs[j] = right.coeffs[j];
            }
        }
        Polynomial result = new Polynomial(resCoeffs);
        return result;
    }

    public Polynomial multiply(Polynomial right) {
        int[] resCoeffs = new int[coeffs.length + right.coeffs.length - 1]; //array of resulting coeffs
        for(int i = 0; i < coeffs.length; i ++) {
            for(int j = right.coeffs.length - 1; j >= 0; j -- ){
                resCoeffs[i + j] += coeffs[i] * right.coeffs[j];
            }
        }
        Polynomial res = new Polynomial(resCoeffs);
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Polynomial)) return false;
        Polynomial polynomial = (Polynomial) o;
        return Arrays.equals(coeffs, polynomial.coeffs);
    }

    @Override
    public int hashCode() {
        int result = 17;
        for(int i = 0; i < coeffs.length; i++ ) {
            result = 31 * result + coeffs[i];
        }
        return result;
    }

    @Override
    public String toString() {
        return "Array: " + Arrays.toString(getCoeffs());
    }


}
