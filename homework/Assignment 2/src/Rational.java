import java.math.BigDecimal;
import java.util.Scanner;

public class Rational {

	private Scanner input = new Scanner(System.in);

	private static int decimalPlace;

	private int numerator;
	private int denominator;


	// taking in a 2 arguments constructor
	public Rational(int numerator, int denominator) {

		// throw error if denominator is 0
		if (denominator != 0) {
			long gcf = gcf(numerator, denominator);
			
			this.numerator= (int) ((int) numerator/gcf);
			this.denominator= (int) ((int) denominator/gcf);
		} else {
			throw new IllegalArgumentException("denominator cannot be 0");
		}
	}

	// no-argument constructor
	public Rational() {
		System.out.print("Enter the numerator and denominator of a rational number: ");
		this.numerator = input.nextInt();
		this.denominator = input.nextInt();

		// throw error if denominator is 0
		if (this.denominator != 0) {
			long gcf = gcf(numerator, denominator); // get greatest common factor
			
			// set and divide by GCF
			this.numerator= (int) ((int) numerator/gcf);
			this.denominator= (int) ((int) denominator/gcf);
		} else {
			throw new IllegalArgumentException("denominator cannot be 0");
		}
	}

	public static String add(Rational first, Rational second) {

		int n = (first.numerator * second.denominator) + (second.numerator * first.denominator);
		int d = first.denominator * second.denominator;

		return "Addition result in the form of a/b is "+rationalAsString(n, d)+" and floating-point format is "+rationalAsFloatingPoint(n, d);
	}

	public static String subtract(Rational first, Rational second) {
		int n = (first.numerator * second.denominator) - (second.numerator * first.denominator);
		int d = first.denominator * second.denominator;

		return "Subtraction result in the form of a/b is "+rationalAsString(n, d)+" and floating-point format is "+rationalAsFloatingPoint(n, d);
	}

	public static String multiply(Rational first, Rational second) {

		int n = (first.numerator * second.numerator);
		int d = (first.denominator * second.denominator);

		return "Multiplication result in the form of a/b is "+rationalAsString(n, d)+" and floating-point format is "+rationalAsFloatingPoint(n, d);
	}

	public static String divide(Rational first, Rational second) {
		// flipping the second number over and multiply
		int n = (first.numerator * second.denominator);
		int d = (first.denominator * second.numerator);

		long gcf = gcf(n, d); // get greatest common factor
		Rational result = new Rational((int)((int)n/gcf), (int) ((int)d/gcf)); // new Rational divided by GCF

		return "Dividision result in the form of a/b is "+rationalAsString(result.numerator, result.denominator)+" and floating-point format is "+rationalAsFloatingPoint(result.numerator, result.denominator);
	}

	public static String rationalAsString(int n, int d) {

		return n+"/"+d;
	}

	public static float rationalAsFloatingPoint(int n, int d) {
		return round((float)((double)n / (double)d));
	}

	public static void print(String result) {
		System.out.println(result);
	}

	// getting greatest common factor
	private static long gcf(int n, int d) {
		return d == 0 ? n : gcf(d, n % d);
	}
	
	// uses precision variable set by input and rounds the number
	public static float round(float number) {
		BigDecimal bd = new BigDecimal(number);
		bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}
	
	// set precision decimal from input
	public static void setPrecision(int decimal) {
		decimalPlace = decimal;
	}

	public int getPrecision() {
		return decimalPlace;
	}
	
	// used to close the Scanner
	public void closeScanner() {
		input.close();
	}

}
