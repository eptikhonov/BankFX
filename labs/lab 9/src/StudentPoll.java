import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Fig. 7.8: StudentPoll.java
// Poll analysis program.

public class StudentPoll {
	static int maxValue = 0;

	public static void main(String[] args) {
		// student response array (more typically, input at runtime)
		ArrayList<Integer> responses = new ArrayList<Integer>();

		// getting integers from numbers.txt and into responses array
		readSurveryResponses("numbers", responses);

		int[] frequency = new int[maxValue + 1]; // array of frequency counters

		// for each answer, select responses element and use that value
		// as frequency index to determine element to increment        
		for (int answer = 0; answer < responses.size(); answer++) {    
			try {                                                       
				++frequency[responses.get(answer)];                          
			}                                                           
			catch (ArrayIndexOutOfBoundsException e) {                  
				System.out.println(e); // invokes toString method
				System.out.printf("   responses[%d] = %d%n%n",           
						answer, responses.get(answer));                           
			}                                                           
		}

		// creating output.txt that has ratings from numbers.txt
		try (Formatter output = new Formatter("output.txt")) {

			output.format("%s%10s%n", "Rating", "Frequency");

			try {
				// add rating and frequency to the file
				for (int rating = 0; rating < frequency.length; rating++) {
					if (frequency[rating] != 0) {
						output.format("%6d%10d%n", rating, frequency[rating]);
					}
				}
				
				System.out.println("Please check output.txt");

			} catch (NoSuchElementException e) {
				System.err.print("Invalid input. Please try again.");
			}

		} catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
			e.printStackTrace();
		}

	} 

	// open fileName.txt, read it's content, add to integers to ArrayList, and close the file
	public static void readSurveryResponses(String fileName, ArrayList<Integer> responses) {
		try (Scanner input = new Scanner(Paths.get(fileName+".txt"))) {

			// read integer form file
			while(input.hasNext()) { // while there is more to read
				responses.add(input.nextInt()); // add each integer to array

			}

			// get max integer from responses array
			for (int num : responses) {
				if (maxValue < num) {
					maxValue = num;
				}
			}

		} catch (NoSuchElementException | IllegalStateException | IOException e) {
			e.printStackTrace();
		}

	}
} 


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
