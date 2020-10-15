package datastructures.designpatterns.facade;

import datastructures.designpatterns.facade.vehicles.Bike;
import datastructures.designpatterns.facade.vehicles.Car;
import datastructures.designpatterns.facade.vehicles.Plane;

public class FacadeDemo {
 
    public static Vehicle plane;
    public static Vehicle car;
    public static Vehicle bike;
    

    public static void main(String[] args) {
        plane = new Plane();
        car = new Car();
        bike = new Bike();

        bike.move();
        car.move();
        plane.move();

        for(Vehicle vehicle : new Vehicle[] {bike, car, plane}){
            vehicle.move();
        }

    }





}
