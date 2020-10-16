/**
 * William Meathrel
 * Sept 30 2020
 * A project to learn hashmaps
 */
package datastructures;

import java.util.HashMap;

public class HashmapProject {

	// Initalizes hashmaps with type string and integer
	HashMap<String, Integer> satelliteHashMap = new HashMap<>();

    public static void main(String[] args) {
		// Initazlies the Hashmap Project object
		new HashmapProject();
		

    }

    public HashmapProject() {
		// Adds 4 satellites to the Hashmaps
        satelliteHashMap.put("Satellite Apple", booleanToInt(false, true, false, true));
        satelliteHashMap.put("Satellite Banana", booleanToInt(true, true, true, true));
        satelliteHashMap.put("Satellite Carrot", booleanToInt(false, false, false, true));
        satelliteHashMap.put("Satellite Date", booleanToInt(false, false, false, false));

		// The prints out each key and value
        satelliteHashMap.forEach(this::output);

		// This prints the status of satellite banana
        printStatus(satelliteHashMap.get("Satellite Banana"));

		// This prints out all Satellites that are in service
        satelliteHashMap.forEach(this::filterInService);

    }

	// This method prints out all k, v in a hashmap
    public void output(String key, Integer value) {
        System.out.printf("Satellite: %s Status: %s%n", key, value.toString());
    }

	// This method only prints out k, v that are in service
    public void filterInService(String key, Integer value){
		// Checks if the byte in first position is 1
        if((value & 0b0100) == 4){
            System.out.println(key);
        }

    }

	// This method prints out the status with the correlating data
    public void printStatus(int status) {
		// Uses the intToBoolean method to decode the status
        boolean[] decodedValue = intToBoolean(status);

		// Prints out the data
        System.out.printf(
                "Satellite in Orbit: %b, Satellite in Service %b, Satellite has Antenna %b, Satellite has Laser %b%n",
                decodedValue[0], decodedValue[1], decodedValue[2], decodedValue[3]);
    }

	// Converts an int to it boolean values
    public boolean[] intToBoolean(int number) {

		// Checks if the position in numbers has a 1 and if it does add true to the list
        boolean[] values = { (number & 0b1000) == 8, (number & 0b0100) == 4, (number & 0b0010) == 2,
                (number & 0b0001) == 1 };

        return values;
    }

	// Convert the status to a number
    public int booleanToInt(boolean inOrbit, boolean inService, boolean hasAntenna, boolean hasLaser) {
		// Initalizes the number as 0
        int number = 0;

		// Checks if the parameter is true then adds the correspoding bit if it true
        number += inOrbit ? 0b1000 : 0b0000;
        number += inService ? 0b0100 : 0b0000;
        number += hasAntenna ? 0b0010 : 0b0000;
        number += hasLaser ? 0b0001 : 0b0000;

        return number;
    }

}
