/*
 * William Meathrel
 * 17/9/2020
 * A program that sorts list using insertion sort
 */
package insertionsort;

import java.util.Random;

// My insertion sort app
public class App {
    

    public static void main(String[] args) {
		// Generates a length 100 list using the generate list method
		int[] insertArray = generateList(100);
		// Prints out the unsorted list
		printArray(insertArray);

		// Sorts the list using the insertion sort method
		insertArray = insertionsort(insertArray);

		// Prints out the sorted array
		printArray(insertArray);
	
	}

	/**
	 * Generates a list filled with random numbers between 1 and 10
	 *  
	 * @param the length that the list should be
	 * 
	 * @return a randomly generated list
	 */
	public static int[] generateList(int length){
		// Initalizes a random class
		Random random = new Random();

		// Initalizes a list of the length given
		int[] randomNumbers = new int[length];

		// Uses a for loop to fill the array with random numbers between 0 and 10
		for(int i = 0; i<length; i++){
			randomNumbers[i] = random.nextInt(10);
		}

		// returns a randomly generated list
		return randomNumbers;
	}

	/**
	 * Prints out and array
	 * 
	 * @param array the array to be printed out
	 */
	public static void printArray(int[] array){
		
		// Prints out each element of the array and appends a comma to the end.
		for(int i = 0; i<array.length; i++){
			System.out.print(array[i] + ",");
		}
		// Adds a line to the end
		System.out.println();
	}

	/**
	 * Sorts an array using insertion sort.
	 * 
	 * @param array The array to be sorted
	 * @return a sorted array
	 */
	public static int[] insertionsort(int[] array){
		// Uses 2 variables to know where in the list the end is,
		int loops = 0;
		int length = array.length;

		// for each number in the list find the greatest number
		for(int i = 0; i < length; i++){

			// Sets the current largest number to the first one in the list
			int largest = 0;

			// for each number that hasn't been sorted already find the largest number
			for(int j = 0; j < length - loops; j++){
				
				// If the new number is bigger than the last number set it to the new biggest number
				if(array[largest] < array[j]){
					largest = j;
				}
				
			}
			// Increase the loop position
			loops++;
			// Swap the biggest and farthest point that hasn't been looked at yet.
			int temp = array[length - loops];
			array[length - loops] = array[largest];
			array[largest] = temp;
		}

		return array;

	}


}
