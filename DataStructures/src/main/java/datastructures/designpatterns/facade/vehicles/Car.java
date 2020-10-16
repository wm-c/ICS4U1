package datastructures.designpatterns.facade.vehicles;

import datastructures.designpatterns.facade.Vehicle;

public class Car implements Vehicle{

    @Override
    public void move() {
        System.out.println("Car Drives Away");

    }
    
}
