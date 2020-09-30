package datastructures;



public class PrintfProject{
    
    public static void main(String[] args) {
        new PrintfProject();
        
    }

    public PrintfProject(){
        System.out.println("  X |  Y");
        System.out.println("----+--------");
        for(int i = -2; i < 13; i++){
            System.out.printf("%+3d |%7.3f %n", i, calculateValue(i));
        }
    }

    public double calculateValue(int x){
        return 8 * Math.sqrt(x) - 10 * Math.sin(x) - 0.003 * Math.pow(x, 3) - 5;
    }

}
