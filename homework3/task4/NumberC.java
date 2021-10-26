package homework3.task4;

public class NumberC {
    public static void main(String[] args) {
        int length = 10;
        int[] arrayOfNumbers = new int[length];
        for(int i = 0; i < length; i ++) {
            arrayOfNumbers[i] = (int)(Math.random() * 101);
        }

        System.out.print("Massive of random numbers: ");
        for(int i = 0; i < length; i++) {
            System.out.print(arrayOfNumbers[i] + " ");
        }

        for(int i = 0; i < length; i++) {
            if(i % 2 != 0) {
                arrayOfNumbers[i] = 0;
            }
        }

        System.out.println();
        System.out.print("New massive with zero in the odd indexes: ");
        for(int i = 0; i < length; i++) {
            System.out.print(arrayOfNumbers[i] + " ");
        }
    }

}
