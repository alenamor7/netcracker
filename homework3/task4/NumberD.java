package homework3.task4;

import java.util.Arrays;

public class NumberD {
    public static void main(String[] args) {
        int length = 15;
        int[] ArrayOfNumbers = new int[length];
        for(int i = 0; i < length; i++) {    //fill array with random numbers from - 50 to 50
            ArrayOfNumbers[i] = (int)(Math.random() * 101) - 50;
        }
        System.out.println("Array: " + Arrays.toString(ArrayOfNumbers));  //print array

        int min = ArrayOfNumbers[0], max = ArrayOfNumbers[0];
        for(int i = 1; i < length; i ++) {  //find max and min numbers in random array
            if(ArrayOfNumbers[i] < min){
                min = ArrayOfNumbers[i];
            }
            if(ArrayOfNumbers[i] > max){
                max = ArrayOfNumbers[i];
            }
        }

        int minLastIndex = 0, maxLastIndex =0;  //
        for(int i = length - 1; i > 0; i--){
            if(ArrayOfNumbers[i] == min){
                minLastIndex = i;
                break;
            }
        }
        for(int j = length - 1; j > 0; j--){
            if(ArrayOfNumbers[j] == max) {
                maxLastIndex = j;
                break;
            }
        }

        System.out.println("The max number is " + max + " was last seen in the massive at index " + maxLastIndex);
        System.out.println("The min number is " + min + " was last seen in the massive at index " + minLastIndex);


    }

}
