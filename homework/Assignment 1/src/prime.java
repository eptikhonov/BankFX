import java.util.ArrayList;
import java.util.Scanner;

public class prime {

	public static void main(String[] args) {

		ArrayList<Integer> primeFactors = new ArrayList<Integer>();

		// getting user input
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		
		// checking if input is negative
		while (number < 0) {
			System.out.print("Please enter a positive integer: ");
			number = input.nextInt();
		}

		input.close(); // closing input

		// checking if input is prime, if not then add i to the ArrayList
		int temp = number;
		for (int i = 2; i <= number; i++) {
			while (temp % i == 0) {
				primeFactors.add(i);
				temp = temp / i;
			}
		}

		// if first integer in array is the input itself, then it is prime. Otherwise, print prime factors
		if (primeFactors.get(0) == number) {
			System.out.println("The number "+number+" is prime");
		} else {
			System.out.print("The prime factors of "+number+" are ");
			for (int num: primeFactors) {
				System.out.print(num + " ");
			}
		}
	}
}
