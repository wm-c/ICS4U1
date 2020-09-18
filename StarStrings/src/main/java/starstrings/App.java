package starstrings;

public class App {

	public static String message = "The unusually warm weather makes me think of summer. It is hard to stay focused on mundane work.";
	
	public static String[] splitMessage;

	public static void main(String[] args) {
		splitMessage = message.split(" ");

		for (int i = 0; i < 23; i++) {
			System.out.print("*");
		}
		System.out.println();

		StringBuilder stringBuilder = new StringBuilder("* ");

		int wordLength;

		for (String word : splitMessage) {
			wordLength = word.length();

			if (stringBuilder.length() + wordLength > 20) {
				while (stringBuilder.length() < 21) {
					stringBuilder.append(" ");
				}

				stringBuilder.append(" *");
				System.out.println(stringBuilder.toString());
				stringBuilder.delete(0, stringBuilder.length() - 1);
				stringBuilder = new StringBuilder("* ");
			}

			stringBuilder.append(word + " ");

		}

		if (stringBuilder.length() > 3) {
			while (stringBuilder.length() < 21) {
				stringBuilder.append(" ");
			}
			stringBuilder.append(" *");
			System.out.println(stringBuilder.toString());
		}

		for (int i = 0; i < 23; i++) {
			System.out.print("*");
		}
		System.out.println();

	}

	public static void printStringArray(String[] stringArray) {
		for (String string : stringArray) {
			System.out.printf(" %s,", string);
		}
		System.out.println();
	}
}