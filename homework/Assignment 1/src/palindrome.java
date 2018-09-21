import java.util.Scanner;

public class palindrome {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// get input
		int number = input.nextInt();
		
		int numberLength = String.valueOf(number).length();
		int numberReverse;
		
		// check if input is a 5-digit integer
		if (numberLength != 5) {

			// ask for another input that is a 5-digit integer
			while (numberLength != 5) {
				System.out.println("Invalid number");
				number = input.nextInt();
				numberLength = String.valueOf(number).length();
			}
		}
		
		input.close(); // close user input
		
		// reversing the input as a String and saving it as the variable called reverse
		String reverse = "";
		for (int i = numberLength - 1; i >= 0; i--) {
			// use i to index backwards of string
			reverse += String.valueOf(number).charAt(i);
		}
		
		// converting reverse string to integer
		numberReverse = Integer.parseInt(reverse);
		
		// check if input is equivalent to input being reversed
		if (numberReverse == number) {
			System.out.println("The number is palindrome");
		} else {
			System.out.println("The number is not palindrome");
		}
	}

}
