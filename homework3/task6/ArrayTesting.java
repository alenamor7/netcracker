package homework3.task6;

public class ArrayTesting {
    public static void main(String[] args) {
        int length = 50;
        int[] randomNumbers = new int[length];
        for(int i = 0; i < length; i++ ){  //fill array with numbers [0,10]
            randomNumbers[i] = (int)(Math.random() * 11);
        }

        //switch-case
        long startTime1 = System.nanoTime();
        int[] counts1 = new int[11];  //array of counts of numbers in array using switch-case
        for(int i = 0; i < length; i ++){  //counting the number of number's appearance in the array
            switch(randomNumbers[i]){
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    counts1[randomNumbers[i]] += 1; //randomNumbers[i] is a number in [0,10]
                    break;
            }
        }
        long estimatedTime1 = System.nanoTime() - startTime1;
        for(int num = 0; num < counts1.length; num++){  //print result
            System.out.println("Number " + num + " appears in the array " + counts1[num] + " times");
        }
        System.out.println("Counting with switch-case was made for " + estimatedTime1);
        System.out.println();

        //if-else
        long startTime2 = System.nanoTime();
        int[] counts2 = new int[11];   //array of counts of numbers in array using if-else
        for(int i = 0; i < length; i++) {
            if(randomNumbers[i] == 0) {
                counts2[0] +=1;
            }
            else if(randomNumbers[i] == 1) {
                counts2[1] +=1;
            }
            else if(randomNumbers[i] == 2) {
                counts2[2] +=1;
            }
            else if(randomNumbers[i] == 3) {
                counts2[3] +=1;
            }
            else if(randomNumbers[i] == 4) {
                counts2[4] +=1;
            }
            else if(randomNumbers[i] == 5) {
                counts2[5] +=1;
            }
            else if(randomNumbers[i] == 6) {
                counts2[6] +=1;
            }
            else if(randomNumbers[i] == 7){
                counts2[7] +=1;
            }
            else if(randomNumbers[i] == 8) {
                counts2[8] +=1;
            }
            else if(randomNumbers[i] == 9) {
                counts2[9] +=1;
            }
            else if(randomNumbers[i] == 10) {
                counts2[10] +=1;
            }
        }
//        or
//        for(int i = 0; i < length; i ++) {
//            for(int j = 0; j <= 10; j++){
//                if(randomNumbers[i] == j){
//                    counts2[j] += 1;
//                }
//            }
//        }
        long estimatedTime2 = System.nanoTime() - startTime2;
        for(int num = 0; num < counts2.length; num++){  //print result
            System.out.println("Number " + num + " appears in the array " + counts2[num] + " times");
        }
        System.out.println("Counting with if-else was made for " + estimatedTime2);
    }
}
