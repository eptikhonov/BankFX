import java.util.Scanner;
import java.math.BigDecimal;

public class Complex {

	private Scanner input = new Scanner(System.in);
	private float realPart;
	private float imaginaryPart;
	
	
	// no arguments, ask user for input instead
	public Complex() {
		System.out.print("Please enter the real and imaginary part of a complex number: ");
		this.realPart = (float) input.nextDouble();
		this.imaginaryPart = (float) input.nextDouble();
	}
	
	// 2 arguments constructor
	public Complex(double realPart, double imaginaryPart) {
		this.realPart = (float) realPart;
		this.imaginaryPart = (float) imaginaryPart;
	}
	
	// returns string of the addition of both real numbers and imaginary numbers
	public static String add(Complex first, Complex second) {
		return "Addition result: ("+round(first.realPart + second.realPart, 2)+", "+round(first.imaginaryPart + second.imaginaryPart, 2)+")";
	}
	
	// returns string of the subtraction of both real numbers and imaginary numbers
	public static String subtract(Complex first, Complex second) {
		return "Subtraction result: ("+round(first.realPart - second.realPart, 2)+", "+round(first.imaginaryPart - second.imaginaryPart, 2)+")";
	}
	
	// rounds floats with BigDecimal
	public static float round(float number, int decimalPlace) {
		BigDecimal bd = new BigDecimal(number);
		bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}
	
	// print calculation results
	public static void print(String result) {
		 System.out.println(result);
	}
	
	// used to close the Scanner
	public void closeScanner() {
		input.close();
	}

}
