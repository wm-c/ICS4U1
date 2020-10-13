package elevator;

public class Elevator {

	// Manufacturer
	public static final String manufacturer = "Otis";

	// Max floor
	public static final int topFloor = 19;

	// Max Occupents
	public static final int maxOccupants = 25;

	// Is the power on
	public static boolean powerOn = true;

	private int floor;
	private int people;
	private boolean doorsOpen;

	public Elevator() {
		this(1);
	}

	public Elevator(int floor) {

		if (floor > topFloor || floor < 1) {
			floor = 1;
		}

		this.floor = floor;

		people = 0;
		doorsOpen = false;

	}

	public static void setPowerState(boolean powerState) {
		if (powerState != powerOn) {
			System.out.printf("Powering %s%n", powerState ? "On" : "Off");
		}
		powerOn = powerState;
	}

	public static boolean getPowerState() {
		return powerOn;
	}

	public void goToFloor(int newFloor) {
		if (!getPowerState()) {
			System.out.println("Power not on");
			return;
		} else if (newFloor > topFloor || newFloor < 1) {
			System.out.println("Floor not valid");
			return;
		} else if (doorsOpen) {
			System.out.println("Doors aren't open");
			return;
		}

		floor = newFloor;
	}

	public void openDoors() {
		if (!getPowerState()) {
			System.out.println("Power not on");
			return;
		}

		doorsOpen = true;
	}

	public void closeDoors() {
		if (!getPowerState()) {
			System.out.println("Power not on");
			return;
		}

		doorsOpen = false;
	}

	public void addPeople(int newPeople) {
		if (newPeople + people > maxOccupants) {
			System.out.println("To many people");
			return;
		} else if (!doorsOpen) {
			System.out.println("Doors are shut");
			return;
		} else if (newPeople < 0) {
			System.out.println("Not a positive number");
			return;
		}

		people += newPeople;
		System.out.println(toString());
	}

	public void removePeople(int newPeople) {
		if (people - newPeople < 0) {
			System.out.println("To many few people");
			return;
		} else if (!doorsOpen) {
			System.out.println("Doors are shut");
			return;
		} else if (newPeople < 0) {
			System.out.println("Not a positive number");
			return;
		}

		people -= newPeople;
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return String.format("Manufacturer %s, Floor %d, Number of People %d, Doors are ", manufacturer, floor, people,
				doorsOpen ? "Open" : "Closed");
	}


	@Override
	public boolean equals(Object obj) {
		if(obj.getClass().equals(getClass())){
			Elevator compareElevator = (Elevator)(obj);
			if(compareElevator.doorsOpen == doorsOpen && compareElevator.floor == floor && compareElevator.people == people){
				return true;
			}
		}

		return false;
	}
}
