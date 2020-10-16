package datastructures.designpatterns.singletons;

public class Singleton {
    
    public static void main(String[] args) {

        // Without Fills and print array
        Nonsingleton.fillArray();
        Nonsingleton.printArray();


        // Singleton example
        SingletonExample.getInstance().printArray();


        // What if someone else fills array somewhere else in the code?
        // What if instead of filling random numbers it was resetting a rockets guidance computer?


    }





}
