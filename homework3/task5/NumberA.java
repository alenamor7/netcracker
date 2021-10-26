package homework3.task5;

import java.util.Arrays;

public class NumberA {
    public static void main(String[] args) {
        int length = 8;
        int[][] numbersArray = new int[length][length];
        for(int i = 0; i < length; i++ ) {   //fill array with random numbers
            for(int j = 0; j < length; j++) {
                numbersArray[i][j] = (int)(Math.random() * 99 + 1); //[1,99] : plus 1 is necessary to avoid appearing number 0
            }
        }

        System.out.println("Array: ");  //not necessary, but useful for checking a result
        for(int i = 0; i < 8; i++ ) {
            for(int j = 0; j < 8; j++) {
                System.out.print(numbersArray[i][j] + " ");
            }
            System.out.println();
        }

        //can use also:
        //System.out.println(Arrays.deepToString(numbersArray));

        int countMain = 0;
        for(int i = 0; i < length; i++) {
            countMain += numbersArray[i][i];   //summing numbers in main diagonal
        }

        int countColater = 0;
        for(int i = 0; i < length; i ++) {
            countColater += numbersArray[length - 1 - i][i]; //summing numbers in collateral diagonal
        }

        System.out.println();
        System.out.println("The summary of elements in main diagonal: " + countMain);
        System.out.println("The summary of elements in collateral diagonal: " + countColater);
    }
}
