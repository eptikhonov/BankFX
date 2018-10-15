import java.util.Scanner;

public class Rational_Tester {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// asks for input for each instance created
		Rational first = new Rational(); //  2 3
		Rational second = new Rational(); // 4 5
		
		// enter digits of precision
		System.out.print("Enter the number of digits of precision to display to the right of the decimal point: ");
		Rational.setPrecision(input.nextInt()); // 6
		System.out.println();
		
		// closing scanners
		input.close();
		first.closeScanner();
		second.closeScanner();
		
		// calculations with objects above and prints to console
		Rational.print(Rational.add(first, second));
		Rational.print(Rational.subtract(first, second));
		Rational.print(Rational.multiply(first, second));
		Rational.print(Rational.divide(first, second));	
		
	}
	
}
