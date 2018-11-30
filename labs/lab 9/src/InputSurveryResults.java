import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputSurveryResults {

	public static void main(String[] args) {
		//prompts the user for survey responses and outputs each response to a file. Use a Formatter to create a file called numbers.txt. Each integer should be written using method format.

		try (Formatter output = new Formatter("numbers.txt")) {
			
			Scanner input = new Scanner(System.in);
			System.out.println("Enter integers then enter end-of-file indicator to end input.");

			System.out.print("? ");
			
			while (input.hasNext()) {
				try {
					output.format("%d ", input.nextInt());
				} catch (NoSuchElementException e) {
					System.err.print("Invalid input. Please try again.");
					input.nextLine();
				}
				System.out.print("? ");
			}
			
			input.close();
			
			System.out.println("Please check numbers.txt");

		} catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
			e.printStackTrace();
		}

	}

}
