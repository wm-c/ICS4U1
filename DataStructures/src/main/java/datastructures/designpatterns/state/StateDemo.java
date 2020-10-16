package datastructures.designpatterns.state;

public class StateDemo {
    public static int[] inputs = {1, 2, 0, 2};


    public static void main(String[] args) {
        for (int input : inputs) {


            switch(input){


                case 0:
                    System.out.println("Value 0");
                    break;
                case 1:
                    System.out.println("Value 1");
                    break;
                case 2:
                    System.out.println("Value 2");
                    break;
            }
        }
    }


}
