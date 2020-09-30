/*
 * William Meathrel
 * 17/9/20
 * 
 * A Program to find letters in common.
 */
package lettersincommon;

public class LettersInCommon {

	// List of words 
	public static String[] wordlist = {"guyana", "lotion", "chilly", "doggie", "fledgy", "swanky", "crawly", "physic"};
	
	// The word to check against
	public static String word = "digger";
	
	// The amount of letters that the word has in common
	public static int count;
	
	// The highest count and the word that had that count
    public static int highest = 0;
    public static String highestWord;
    
    public static void main(String[] args) {
		
		// For each word in the list look at how many words it has in common
        for (String string : wordlist) {

			// reset count
			count = 0;
			// for each letter in the word were checking see if it contains the letter if it does increase the count
            for (int i=0; i < string.length(); i++) {
				try {
					// Check if the char at in the word is in the other word
					if(string.contains(String.valueOf(word.charAt(i)))){
						count++;
					}	
				} catch (Exception e) {
					// this should only happen if we run out of characters if it does break
					break;
				}
                
			}
			
			// if this count is bigger than the prievous set it to the new highest
            if(count > highest){
                highest = count;
                highestWord = string;
            }
        }

		// Print out the biggest letter
        System.out.println(highestWord);
    }
}
