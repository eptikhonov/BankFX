import java.util.Scanner;

public class problem2 {

	public static void main(String[] args) {

		int stringLength = 0;
		String inputString = "";

		Scanner input = new Scanner(System.in);

		System.out.print("Enter String: ");
		inputString = input.nextLine();

		System.out.print("Enter String length: ");
		stringLength = input.nextInt();

		for (int i = stringLength; i > 0; i--) {
			System.out.print(inputString.charAt(inputString.length() - i));
		}

	}

}
