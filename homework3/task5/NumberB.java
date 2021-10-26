package homework3.task5;

public class NumberB {
    public static void main(String[] args) {
        int rowSize = 8;
        int columnSize = 5;
        int[][] randomArray = new int[rowSize][columnSize];
        for(int row = 0; row < rowSize; row++ ) {   //fill array with random numbers
            for(int col = 0; col < columnSize; col++) {
                randomArray[row][col] = (int)(Math.random() * 100) * 2 - 99;   //[-99;99]
            }
        }

        System.out.println("Array: ");
        for(int row = 0; row < rowSize; row++ ) {
            for(int col = 0; col < columnSize; col++) {
                System.out.print(randomArray[row][col] + " ");
            }
            System.out.println();
        }

        //can use also:
        //System.out.println(Arrays.deepToString(numbersArray));

        int max = randomArray[0][0];
        int maxRow = 0;
        int maxColumn = 0;
        for(int row = 0; row < rowSize; row++ ) {
            for(int col = 0; col < columnSize; col++) {
                if(randomArray[row][col] > max){
                    max = randomArray[row][col];
                    maxRow = row;
                    maxColumn = col;
                }
            }
        }
        System.out.println();
        System.out.println("Max number in the array is: " + max + "\nIt has raw's index: " + (maxRow + 1) + " and column's index: " + (maxColumn + 1));
        //use (maxRow + 1) and (maxColumn + 1) to print a row or column index(starting from 1)
    }

}
