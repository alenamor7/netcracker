package homework3;
import java.util.*;

public class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //asking user for number of elements
        System.out.println("Enter the number of elements in array:" );
        int n = sc.nextInt();    //n is a length of array(will be using instead of array.length)
        int[] randomArray = new int[n]; //array initialization

        for(int i = 0; i < n; i ++){
            randomArray[i] = (int)(Math.random() * 100 );  //put random numbers in array
        }

        System.out.print("Unsorted massive of random numbers: " + Arrays.toString(randomArray)); //print unsorted array

        //bubble sort
        int[] bubbleArray = randomArray;   //new array for bubble sort
        long startTime1 = System.nanoTime();
        for(int i = n - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(bubbleArray[j] > bubbleArray[j + 1]){
                    int temp = bubbleArray[j];
                    bubbleArray[j] = bubbleArray[j + 1];
                    bubbleArray[j + 1] = temp;
                }
            }
        }
        long estimatedTime1 = System.nanoTime() - startTime1;

        System.out.println();
        System.out.print("Bubble sorted array: " + Arrays.toString(bubbleArray) +
                " was sorted for " + estimatedTime1 + " nanoseconds");  //print information about bubble sorted arrat

        //selection sort
        int[] selectionArray =randomArray;
        long startTime2 = System.nanoTime();
        for(int i = 0; i < n; i++){
            int min = selectionArray[i];
            int min_index = i;
            for(int j = i + 1; j < n; j ++){
                if(selectionArray[j] < min){
                    min = selectionArray[j];
                    min_index = j;
                }
            }
            if(i != min_index){
                int temp = selectionArray[i];
                selectionArray[i] = selectionArray[min_index];
                selectionArray[min_index] = temp;
            }
        }
        long estimatedTime2 = System.nanoTime() - startTime2;

        System.out.println();
        System.out.print("Selection sorted array: " + Arrays.toString(selectionArray)+
                " was sorted for " + estimatedTime2 + " nanoseconds"); //print information about selection sorted array


        //sort with method sort()
        int[] newArray = randomArray;
        long startTime3 = System.nanoTime();
        java.util.Arrays.sort(newArray);
        long estimatedTime3 = System.nanoTime() - startTime3;

        System.out.println();
        System.out.print("Sorted with method sort() array: " + Arrays.toString(newArray) +
                " was sorted for " + estimatedTime3 + " nanoseconds");  //print information about sorted array

        /*This program shows that on the arrays with little numbers of elements:
        seletion sort is better then bubble sort, and method sort() is not effective in this case.
        On the arrays with a lot of numbers(>100) selection sort is still better then bubble sort,
        and the method sort() is the fastest*/

    }
}
