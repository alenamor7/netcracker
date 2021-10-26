package homework3.task3;

public class SymbolsMyFigureA {
    public static void main(String[] args) {
        int sizeRaw = 8;
        int sizeCol = 1;
        for(int raw = 0; raw < sizeRaw; raw ++){
            for(int col = 0; col < sizeCol; col++){
                System.out.print("# ");
            }
            sizeCol++;
            System.out.println();
        }
    }
}
