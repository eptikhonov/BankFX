
public class Complex_Tester {

	public static void main(String[] args) {
		// asks for input for each instance created
		Complex first = new Complex(); // 9.5 7.1
		Complex second = new Complex(); // 3.5 2.2

		System.out.println();
		
		// calculations with objects above and prints to console
		Complex.print(Complex.add(first, second));
		Complex.print(Complex.subtract(first, second));
		
		
		// closing scanners
		first.closeScanner();
		second.closeScanner();
	}

}
