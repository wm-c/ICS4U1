package datastructures.designpatterns.facade.vehicles;

import datastructures.designpatterns.facade.Vehicle;

public class Bike implements Vehicle {

    @Override
    public void move() {
        System.out.println("Bike Pedals Away");

    }
    
}
