import java.util.Scanner;

public class TokenizePhoneNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String telephoneNumber = "";
		String[] telephoneSplitSpacingArray;
		String[] telephoneSplitDashArray;
		String areaCode = "";
		String phoneNumber = "";

		// asking and validating phone number
		while(true) {
			System.out.println("Please enter a phone number:");

			telephoneNumber = input.nextLine();

			// if true, break from while loop
			if (validateTelephoneNumber(telephoneNumber)) {
				break;
			} else {
				System.out.println("\nWrong telephone number format!");
			}
		}

		input.close();

		// splitting phone number by white space and into array
		telephoneSplitSpacingArray = telephoneNumber.split(" ");

		// getting area code without parentheses
		areaCode = telephoneSplitSpacingArray[0].substring(1, 4);

		// splitting phone number further by dash and into array
		telephoneSplitDashArray = telephoneSplitSpacingArray[1].split("-");

		// adding both parts of the last 7 characters
		phoneNumber = telephoneSplitDashArray[0]+telephoneSplitDashArray[1];

		// printing phone information
		System.out.println("Area Code: "+areaCode);
		System.out.println("Phone Number: "+phoneNumber);
	}

	public static boolean validateTelephoneNumber(String telephoneNumber) {
		return telephoneNumber.matches("\\([1-9]\\d{2}\\)\\s[1-9]\\d{2}-\\d{4}");
		// regex example: (123) 456-7890
	}

}
