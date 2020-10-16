package datastructures.designpatterns.singletons;

import java.util.Random;

public class Nonsingleton {
    
    // Make a static list
    public static double[] list;

    // Make a static function to fill array
    public static void fillArray(){
        list = new double[10];

        for (int i = 0; i < 10; i++) {
            list[i] = new Random().nextInt(30);
        }

    }

    // Print the array
    public static void printArray(){
        for (double d : list) {
            System.out.println(d);
        }
    }


}
