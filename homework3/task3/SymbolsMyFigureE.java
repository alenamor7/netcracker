package homework3.task3;

public class SymbolsMyFigureE {
    public static void main(String[] args) {
        int sizeRaw = 7;
        int sizeCol = 7;
        for(int i = 0; i < sizeRaw; i++) {
            if(i == 0 || i == sizeRaw - 1){
                for(int j = 0; j <sizeCol; j++){ //fill with # first and last raws
                    System.out.print("# ");
                }
            }
            else{
                for(int j = 0; j <sizeCol; j++){
                    if(j == 0 || j == sizeCol - 1){
                        System.out.print("# ");  //fill with # first and last columns
                    }
                    else{
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }

    }
}
