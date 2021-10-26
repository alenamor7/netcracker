package homework3.task4;

import java.util.Arrays;

public class NumberE {
    public static void main(String[] args) {
        int length = 10;
        int[] array1 = new int[length];
        int[] array2 = new int[length];

        for(int i = 0; i < length; i ++) {
            array1[i] = (int)(Math.random() * 11);  //fill arrays with random numbers
            array2[i] = (int)(Math.random() * 11);
        }

        System.out.println("First array: " + Arrays.toString(array1)); //print arrays
        System.out.println("Second array: " + Arrays.toString(array2));

        int res1 = 0, res2 = 0;
        for(int i = 0; i < length; i++) {  //find summary of all elements in arrays
            res1 += array1[i];
            res2 += array2[i];
        }
        double avg1 = (double)res1 / length;  //find average for both arrays
        double avg2 = (double)res2 / length;

        if(avg1 == avg2) {
            System.out.println("Averages of first and second arrays are equal. The average is: " + avg1);
        }
        else if(avg1 > avg2){
            System.out.println("Average of first array " + avg1 + " is bigger then average of second array " + avg2);
        }
        else if(avg2 > avg1){
            System.out.println("Average of second array " + avg2 + " is bigger then average of first array " + avg1);

        }


    }
}
