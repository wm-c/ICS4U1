package datastructures;

import java.util.HashMap;

public class HashmapProject {

    HashMap<String, Integer> satelliteHashMap = new HashMap<>();

    public static void main(String[] args) {

        new HashmapProject();

    }

    public HashmapProject() {
        satelliteHashMap.put("Satellite Apple", 13);
        satelliteHashMap.put("Satellite Banana", 5);
        satelliteHashMap.put("Satellite Carrot", 8);
        satelliteHashMap.put("Satellite Date", 9);

        satelliteHashMap.forEach(this::output);

        printStatus(satelliteHashMap.get("Satellite Banana"));

        satelliteHashMap.forEach(this::filterInService);

    }

    public void output(String key, Integer value) {
        System.out.printf("Satellite: %s Status: %s%n", key, value.toString());
    }

    public void filterInService(String key, Integer value){
        if((value & 0b0001) == 1){
            System.out.println(key);
        }

    }

    public void printStatus(int status) {
        boolean[] decodedValue = intToBoolean(status);

        System.out.printf(
                "Satellite in Orbit: %b, Satellite in Service %b, Satellite has Antenna %b, Satellite has Laser %b%n",
                decodedValue[0], decodedValue[1], decodedValue[2], decodedValue[3]);
    }




    public boolean[] intToBoolean(int number) {

        boolean[] values = { (number & 0b1000) == 8, (number & 0b0100) == 4, (number & 0b0010) == 2,
                (number & 0b0001) == 1 };

        return values;
    }

    public int booleanToInt(boolean inOrbit, boolean inService, boolean hasAntenna, boolean hasLaser) {
        int number = 0;

        number += inOrbit ? 0b1000 : 0b0000;
        number += inService ? 0b0100 : 0b0000;
        number += hasAntenna ? 0b0010 : 0b0000;
        number += hasLaser ? 0b0001 : 0b0000;

        return number;
    }

}
