package com.netcracker;

public class EquatationModel {
    private double a;
    private double b;
    private double c;
    private double x1, x2;
    private String result = "";


    public EquatationModel(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;

        double discr = b * b - 4 * a * c;
        if(discr < 0){
            this.result = "No roots";
        }
        else if(discr == 0) {
            x1 = x2 = - b / (2 * a);
            this.result = " x = " + x1;
        }
        else if(discr > 0) {
            x1 = (-b + Math.sqrt(discr)) / 2*a;
            x2 = (-b - Math.sqrt(discr)) / 2*a;
            this.result = "x1 = " + x1 + ", " +
                    "x2 = " + x2;
        }
    }

    public String getResult() {
        return result;
    }

}
