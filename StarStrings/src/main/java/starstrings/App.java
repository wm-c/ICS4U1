/*
 * William Meathrel
 * 17/9/2020
 * 
 * A program that puts starts around a string.
 */
package starstrings;

import java.util.Scanner;


public class App {
	public static boolean end = false;
    public static String message = "The unusually warm weather makes me think of summer. It is hard to stay focused on mundane work.";
    public static final int length = 20;
    public static int pointer = 0;

    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//System.out.print("Enter a string: ");
		//message = scanner.nextLine();
		//scanner.close();

        for(int i = 0; i<length + 4; i++){
            System.out.print("*");
        }

        System.out.print("\n");

        while(!end){

			String line = getPhrase();
			
			
            System.out.print("* ");

            System.out.print(line);

            System.out.println(" *");
        }



        for(int i = 0; i<length + 4; i++){
            System.out.print("*");
        }
        System.out.print("\n");

		
    }

    public static String getPhrase(){

		String tempMessage;

		if(message.length() - pointer <= length){
			end = true;
			tempMessage = message.substring(pointer, message.length());
		}else{

			tempMessage = message.substring(pointer, clamp(pointer + length, 0, message.length() - 1));
			int end = tempMessage.lastIndexOf(" ");

			tempMessage = tempMessage.substring(0, end);

			pointer += tempMessage.length();
		}
		
		
		if(tempMessage.startsWith(" ")){
			tempMessage = tempMessage.stripLeading();
		}

		while(tempMessage.length() != length){
			tempMessage += " ";
		}

		return tempMessage;
		
    }

    public static int clamp(int clampedNumber, int lowerClamp, int upperClamp){
        return Math.min(Math.max(clampedNumber, lowerClamp), upperClamp);
    }
}
