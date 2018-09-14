import java.util.Scanner;

public class lab_1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// asking for user input for the limit
		System.out.print("Enter the number in the fibonacci sequence: ");
		int limit = input.nextInt();
		
		fibonacci(limit);
		
		// close scanner input
		input.close();
		
	}
	
	private static void fibonacci(int limit) {
		
		// create array with limit from input
		long[] fibArray = new long[limit+1];

		// add first 2 elements to fibonacci sequence
		fibArray[0] = 0;
		fibArray[1] = 1;

		// create the fibonacci series and store it in fibArray
		for(int i=2; i <= limit; i++) {
			fibArray[i] = fibArray[i-1] + fibArray[i-2];
		}

		// print the fibonacci number
		System.out.print(fibArray[limit]);
	}
}

