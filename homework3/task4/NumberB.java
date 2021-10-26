package homework3.task4;

public class NumberB {
    public static void main(String[] args) {
        int length = 20;
        int even = 0, odd = 0;

        int[] randomNumbers = new int[length];
        for(int i = 0; i < length; i ++) {
            randomNumbers[i] = (int)(Math.random() * 11);
        }

        System.out.print("Massive: ");
        for(int i = 0; i < length; i++){
            System.out.print(randomNumbers[i] + " ");
        }

        for(int i = 0; i < length; i++){
            //we can consider number 0 to be not odd and not even number, then: if(randomNumbers[i] == 0) continue;
            if(randomNumbers[i] % 2 == 0){
                even++;
            }
            else{
                odd++;
            }
        }

        System.out.println();
        System.out.println("Quantity of even numbers in array: " + even + "\nQuantity of odd numbers in array: " + odd);

    }
}
