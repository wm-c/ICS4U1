package elevator;

import javax.swing.JFrame;

public class ElevTest {

	public static void main(String[] args) {
		Elevator southElevator = new Elevator();
		Elevator eastElevator = new Elevator(5);

		

		// Start and add 10 people
		southElevator.openDoors();
		southElevator.addPeople(10);
		southElevator.closeDoors();

		// 3 get off on the 4th floor
		southElevator.goToFloor(4);
		southElevator.openDoors();
		southElevator.removePeople(3);
		southElevator.closeDoors();

		// The rest get off at the top
		southElevator.goToFloor(Elevator.topFloor);
		southElevator.openDoors();
		southElevator.removePeople(7);
		southElevator.closeDoors();

		// 8 people get in on east
		eastElevator.openDoors();
		eastElevator.addPeople(8);
		eastElevator.closeDoors();

		// Try to add 30 on the 8th floor
		eastElevator.goToFloor(8);
		eastElevator.openDoors();
		eastElevator.addPeople(30);
		eastElevator.closeDoors();

		// Try to go above the top floor & to a negative floor
		eastElevator.goToFloor(30);
		eastElevator.goToFloor(-10);

		// Move both to 2nd floor
		eastElevator.goToFloor(2);
		southElevator.goToFloor(2);

		// Open door on east
		eastElevator.openDoors();

		// Have a power failure
		Elevator.setPowerState(false);

		// Test to make sure you can't move
		eastElevator.closeDoors();
		southElevator.openDoors();
		southElevator.goToFloor(10);
		eastElevator.goToFloor(11);

		// Restore power
		Elevator.setPowerState(true);

		// Turn power on again
		Elevator.setPowerState(true);

		// Make elevator south move up one floor at a time from the ground floor to
		// floor 10, stopping on each floor and opening and closing doors
		southElevator.goToFloor(1);
		for(int i = 1; i < 11; i++){
			southElevator.goToFloor(i);
			southElevator.openDoors();
			southElevator.closeDoors();
		}

		// Optional test .equals
		eastElevator.closeDoors();
		eastElevator.goToFloor(10);
		eastElevator.openDoors();
		eastElevator.removePeople(8);

		southElevator.openDoors();

		System.out.println(southElevator.equals(eastElevator));

	}
}
