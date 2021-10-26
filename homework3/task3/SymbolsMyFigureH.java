package homework3.task3;

public class SymbolsMyFigureH {
    public static void main(String[] args) {
        int sizeRaw = 7;
        int sizeCol = 7;
        int first = 1, second = sizeCol - 2; //indexes of first and last elements in diagonals

        for(int i = 0; i < sizeRaw; i++) {
            if (i == 0 || i == sizeRaw - 1) {
                for (int j = 0; j < sizeCol; j++) { //fill with # first and last raws
                    System.out.print("# ");
                }
            }
            else{
                for(int k = 0; k < sizeCol; k ++) {
                    if(k == first | k == second){ //fill with # diagonals
                        System.out.print("# ");
                    }
                    else{
                        System.out.print("  "); //fill empty elements which are not in diagonals
                    }
                }
                first++; //index of first diagonal
                second--; //index of second diagonal
            }
            System.out.println();
        }

    }
}
