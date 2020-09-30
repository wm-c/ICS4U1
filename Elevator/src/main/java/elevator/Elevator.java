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


	public Elevator(){
		this(1);
	}

	public Elevator(int floor){

		if(floor > topFloor || floor < 1){
			floor = 1;
		}

		

		this.floor = floor;


		people = 0;
		doorsOpen = false;

	}


	public static void setPowerState(boolean powerState) {
		powerOn = powerState;
	}

	public static boolean getPowerState(){
		return powerOn;
	}




}
