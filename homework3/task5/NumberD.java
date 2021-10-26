package homework3.task5;

public class NumberD {
    public static void main(String[] args) {
        int rowSize = 10;
        int columnSize = 7;
        int[][] randomArray = new int[rowSize][columnSize];
        for(int row = 0; row < rowSize; row++ ) {   //fill array with random numbers
            for(int col = 0; col < columnSize; col++) {
                randomArray[row][col] = (int)(Math.random() * 101);   //[0;100]
            }
        }
        System.out.println("Unsorted array: ");    //print an unsorted array
        for(int row = 0; row < rowSize; row++ ) {
            for(int col = 0; col < columnSize; col++) {
                System.out.print(randomArray[row][col] + " ");
            }
            System.out.println();
        }

        //can use also:
        //System.out.println(Arrays.deepToString(numbersArray));

        for(int row = 0; row < rowSize; row++) {  //bubble sort
            for(int i = columnSize - 1; i > 0; i--) {
                for(int j = 0; j < i; j++ ) {
                    if(randomArray[row][j] < randomArray[row][j + 1]){
                        int temp = randomArray[row][j];
                        randomArray[row][j] = randomArray[row][j + 1];
                        randomArray[row][j + 1] = temp;
                    }
                }
            }
        }

        System.out.println("Sorted array: ");    //print a sorted array
        for(int row = 0; row < rowSize; row++ ) {
            for(int col = 0; col < columnSize; col++) {
                System.out.print(randomArray[row][col] + " ");
            }
            System.out.println();
        }
    }
}
