import java.util.Scanner;

public class LetterCounter {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String textEntered;

		System.out.println("Please enter text to be searched: ");

		System.out.println();
		textEntered = input.nextLine();

		//textEntered = "Mr and Mrs Dursley of Number 4 Privet Drive were proud to say that they were perfectly normal, thank you very much. They were the last people you’d ever expect to be involved in anything strange or mysterious, because they just didn’t hold with such nonsense.".toLowerCase();

		input.close();

		// create array mapping of characters
		int[] counts = new int[(int) Character.MAX_VALUE];

		// add the number of occurrences of each character into array
		for (int i = 0; i < textEntered.length(); i++) {
			char charAt = textEntered.charAt(i); // current position in textEntered
			counts[(int) charAt]++; // add 1 to place in array
			// example: charAt = (int) 'a' = 97. counts[97]++
		}

		// printing a-z with count from array
		System.out.println("\nletter\t\t\tcount");
		for (int i = 97; i <= 122; i++) { // ASCII 97 = a, 122 = z
			System.out.println((char) i + ":\t\t\t  " + counts[i]);
		}


	}

}
