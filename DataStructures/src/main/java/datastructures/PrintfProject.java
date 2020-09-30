/**
 * William Meathrel
 * Sept 30 2020
 * A project to learn PrintF statements
 */
package datastructures;



public class PrintfProject{
    
    public static void main(String[] args) {
		// Makes new PrintFProject
        new PrintfProject();
        
    }

	
    public PrintfProject(){
		// Creates the header for the data
        System.out.println("  X |  Y");
		System.out.println("----+--------");
		
		// Calculates the values and formats them to the header
        for(int i = -2; i < 13; i++){
            System.out.printf("%+3d |%7.3f %n", i, calculateValue(i));
        }
    }

	// Function for calculating the values
    public double calculateValue(int x){
        return 8 * Math.sqrt(x) - 10 * Math.sin(x) - 0.003 * Math.pow(x, 3) - 5;
    }

}
