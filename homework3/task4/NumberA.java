package homework3.task4;

public class NumberA {
    public static void main(String[] args) {
        int length = 0;    //find the length of array
        for(int i = 1; i <= 99; i ++) {
            if (i % 2 != 0) {
                length++;
            }
        }

        int[] increaseArray = new int[length];  //initialisation of massive
        int count2 = 0;
        for(int i = 1; i <= 99; i ++) {    //fill massive with odd numbers in increasing order
            if (i % 2 != 0) {
                increaseArray[count2] = i;
                count2++;
            }
        }

        System.out.println("Sorted massive of increasing odd numbers: ");
        for(int i = 0; i <length; i++) {
            System.out.print(increaseArray[i] + " ");
        }

        //sort decreasing massive
        int[] decreaseArray = new int[length];
        for(int i = 0; i < length; i++){
            decreaseArray[i] = increaseArray[length - i - 1];
        }

        System.out.println();
        System.out.println("Sorted massive of decreasing odd numbers: ");
        for(int i = 0; i <length; i++) {
            System.out.print(decreaseArray[i] + " ");
        }

    }
}
