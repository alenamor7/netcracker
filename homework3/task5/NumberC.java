package homework3.task5;

public class NumberC {
    public static void main(String[] args) {
        int rowSize = 8;
        int columnSize = 5;
        int[][] randomArray = new int[rowSize][columnSize];
        for(int row = 0; row < rowSize; row++ ) {   //fill array with random numbers
            for(int col = 0; col < columnSize; col++) {
                randomArray[row][col] = (int)(Math.random() * 11) * 2 - 10;   //[-10;10]
            }
        }
        System.out.println("Array: ");    //print an array
        for(int row = 0; row < rowSize; row++ ) {
            for(int col = 0; col < columnSize; col++) {
                System.out.print(randomArray[row][col] + " ");
            }
            System.out.println();
        }

        //can use also:
        //System.out.println(Arrays.deepToString(numbersArray));

        int[] rowMultiple = new int[rowSize];    //array with the absolute values of multiplication numbers in rows
        for(int row = 0; row < rowSize; row++) {
            rowMultiple[row] = 1;
            for(int col = 0; col < columnSize; col ++) { //fill array rowMultiple with absolute results of multiplication
                rowMultiple[row] = Math.abs(rowMultiple[row] * randomArray[row][col]);
            }
        }

        int maxRowMultiple = rowMultiple[0];
        int indexMaxRowMult = 0;
        for(int i = 1; i < rowSize; i++) {  //find the row with the biggest result of absolute multiplication
            if(rowMultiple[i] > maxRowMultiple){
                maxRowMultiple = rowMultiple[i];
                indexMaxRowMult = i + 1;  //we use (i + 1) to find the number of row(strings with 1, not 0)
            }
        }

        System.out.println();
        System.out.println("Index of row with the most absolute multiplication: " + indexMaxRowMult); //print the index of array
    }
}
