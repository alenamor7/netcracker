package homework3;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();    //n is a quantity if numbers

        //factorial with loop
        long startTime1 = System.nanoTime();
        long res1 = factorialLoop(n);
        long estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println(n + "! = " + res1 + "; was calculated for " + estimatedTime1 + " ns");

        //factorial with recursion
        long startTime2 = System.nanoTime();
        long res2 = factorialRecurs(n);
        long estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println(n + "! = " + res2 + "; was calculated for " + estimatedTime1 + " ns");
    } //these methods'time of finding factorial are equal


    public static long factorialLoop(int n){
        if(n == 0) {
            return 1;
        }
        else {
            long result = 1;
            for (int i = 1; i < n; i++) {
                result *= i;
            }
            return result;
        }
    }

    public static long factorialRecurs(int n){
        if(n == 0){
            return 1;
        }
        else{
            return n * factorialRecurs(n - 1);
        }
    }
}
