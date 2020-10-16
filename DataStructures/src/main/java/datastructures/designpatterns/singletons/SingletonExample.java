package datastructures.designpatterns.singletons;

import java.util.Random;

public class SingletonExample {
    // Create an instance
    private static SingletonExample singletonInstance = null;
    private double[] list;

    // Make a method to get the instance
    public static SingletonExample getInstance(){
        if(singletonInstance == null){
            singletonInstance = new SingletonExample();
        }

        return singletonInstance;

    }

    // Make a constructor
    private SingletonExample(){
        list = new double[10];

        for (int i = 0; i < 10; i++) {
            list[i] = new Random().nextInt(30);
        }
    }

    // print array
    public void printArray(){
        for (double d : list) {
            System.out.println(d);
        }
    }


}
