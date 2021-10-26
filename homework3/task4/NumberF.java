package homework3.task4;
import java.util.Arrays;
import java.util.Random;

public class NumberF {
    public static void main(String[] args) {
        Random random = new Random();
        int length = 20;
        int[] randomArray = new int[length];
        for(int i = 0; i < length;i++ ) {
            randomArray[i] = random.nextInt(3) - 1;  //fill array with random numbers [-1, 0, 1]
        }
        System.out.println("Array: " + Arrays.toString(randomArray));

        int countPlus1 = 0, count0 = 0, countMinus1 = 0;
        for(int i = 0; i < length; i++) {
            if(randomArray[i] == 1) {
                countPlus1++;
            }
            else if(randomArray[i] == 0) {
                count0++;
            }
            else if(randomArray[i] == -1) {
                countMinus1++;
            }
        }

        //print max counts
        if(count0 >= countMinus1 && count0 >= countPlus1) {
            System.out.println("Number 0 appears the most int this array");
        }
        if(countMinus1 >= count0 && countMinus1 >= countPlus1) {
            System.out.println("Number -1 appears the most in the array");
        }
        if(countPlus1 >= count0 && countPlus1 >= countMinus1) {
            System.out.println("Number +1 appears the most in the array");
        }

        //print statements about equality of counts
        if(count0 == countMinus1){
            System.out.println("There is equal quantity of 0 and -1: " + count0);
        }
        if(count0 == countPlus1) {
            System.out.println("There is equal quantity of 0 and +1: " + count0);
        }
        if(countMinus1 == countPlus1) {
            System.out.println("There is equal quantity of +1 and -1: " + countMinus1);
        }
    }
}
