/**
 * William Meathrel Arraylist project
 * Sept 30 2020
 * A project to learn arraylists
 */
package datastructures;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListProject {
	
	// Start by defining an arraylist and initalizing it.
    public static ArrayList<General> generalLists = new ArrayList<>();

    public static void main(String[] args) {
		// Create a new arraylist object
        new ArrayListProject();
    }

    public ArrayListProject(){

		// Adds generals to the arraylist
		addGenerals();
		
		// Prints out the generals
		printGenerals();
		
		// Removes all dead generals from arraylist
		filterDead();
		
		// Print out the Arraylist again
        printGenerals();
    }


	// Defines an inner class, this is the class that is added to the arraylist
    static class General{

		// Set up for some variables
        String name;
        int yearsOfService;
        String country;
        Boolean isAlive;

		// Constructor only initalizes variables
        public General(String name, int yearsOfService, String country, Boolean isAlive){
            this.name = name;
            this.yearsOfService = yearsOfService;
            this.country = country;
            this.isAlive = isAlive;
        }

    }

	// Adds generals to the list
    public static void addGenerals(){
		// Initalizes a general to add them to the list. This is very adhawk but it works.
        generalLists.add(new General("Sun Tzu", 17, "China", false));
        generalLists.add(new General("Douglas MacArthur", 61, "United States", false));
        generalLists.add(new General("Ulysses Grant", 24, "United States", false));
        generalLists.add(new General("Arthur Currie", 23, "Canada", false));
        generalLists.add(new General("Gervais Carpentier", 33, "Canada", true));
    }

	// This prints out the generals and formants it
    public static void printGenerals() {
		// This outputs the header for the information
		System.out.printf("%-20s Years of Service %-15s Alive %n", "General", "Country");
		
		// This prints out the data for each general and aligns it with the header
        for (General general : generalLists) {
            System.out.printf("%-20s %-16d %-15s %b %n", general.name, general.yearsOfService, general.country, general.isAlive);
        }

		// Thes adds an extra line to the bottom to make it better.
        System.out.println();
        
	}
	
	// This removes any general marked as dead
    public static void filterDead(){
		// Creates and iterator for the array list.
		Iterator<General> generalIterator = generalLists.iterator();
		
		// This iterates over the list and removes each general
        while(generalIterator.hasNext()){
            General tempGeneral = generalIterator.next();
            if(!tempGeneral.isAlive){
                generalIterator.remove();
            }
        }
        
    }



}
