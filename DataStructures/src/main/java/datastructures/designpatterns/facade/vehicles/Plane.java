package datastructures.designpatterns.facade.vehicles;

import datastructures.designpatterns.facade.Vehicle;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println("Plane Takes Off");

    }
    
}
