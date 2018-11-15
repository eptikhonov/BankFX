import java.util.Scanner;

public class problem1 {

	public static void main(String[] args) {

		String stringOfCharacters = "";

		Scanner input = new Scanner(System.in);

		System.out.print("Please Enter String of Length 5 or greater and odd: ");
		stringOfCharacters = input.nextLine();


		int length = stringOfCharacters.length();
		int middleIndex = -1;

		if (length > 5 && length % 2 == 1) {
			middleIndex = (length - 1) /2;
			System.out.printf("%s%s%s",stringOfCharacters.charAt(length - 1),
					stringOfCharacters.charAt(0),
					stringOfCharacters.substring(middleIndex - 1, middleIndex + 2));

		} else {
			System.out.println("Invalid String");
		}

	}

}


