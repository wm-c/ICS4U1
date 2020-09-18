package starstrings;

import java.util.Scanner;

/** 
 * William Meathrel 
 * 18/9/2020
 * A program to wrap a message in text
*/
public class Star {

	// The default message used for testing.
	public static String message = "The unusually warm weather makes me think of summer. It is hard to stay focused on mundane work.";
	
	// A variable for holding a split message.
	public static String[] splitMessage;

	public static void main(String[] args) {
		
		// Initalize the scanner
		Scanner scanner = new Scanner(System.in);

		// Get user input and closes the scanner
		System.out.println("Enter a something to be wrapped in stars");
		message = scanner.nextLine();
		scanner.close();
		
		// Splits the message along spaces
		splitMessage = message.split(" ");

		// Adds the top stars
		for (int i = 0; i < 24; i++) {
			System.out.print("*");
		}
		System.out.println();

		// Initalizes the stringbuilder and word length variable
		StringBuilder stringBuilder = new StringBuilder("* ");

		int wordLength;

		// For each word in the split message array see if it makes the stringbuilder to long
		for (String word : splitMessage) {

			// Set the word length variable
			wordLength = word.length();

			// If the adding the word will make the sentence to long fill the message with spaces to a length of 20
			if (stringBuilder.length() + wordLength > 22) {

				// Fills the string builder up to the proper length
				while (stringBuilder.length() < 22) {
					stringBuilder.append(" ");
				}

				// Add the closing star, print the message and reset the string builder
				stringBuilder.append(" *");
				System.out.println(stringBuilder.toString());
				stringBuilder.delete(0, stringBuilder.length() - 1);
				stringBuilder = new StringBuilder("* ");
			}
	
			stringBuilder.append(word + " ");

		}

		// empty the string builder if anything is left
		if (stringBuilder.length() > 3) {
			while (stringBuilder.length() < 22) {
				stringBuilder.append(" ");
			}
			stringBuilder.append(" *");
			System.out.println(stringBuilder.toString());
		}

		// Add bottom stars
		for (int i = 0; i < 24; i++) {
			System.out.print("*");
		}
		System.out.println();

	}
}