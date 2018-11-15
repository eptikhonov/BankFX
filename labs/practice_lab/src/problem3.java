import java.util.Scanner;

public class problem3 {

	public static void main(String[] args) {

		String firstName = "";
		String middleName = "";
		String lastName = "";

		Scanner input = new Scanner(System.in);

		System.out.print("Please Enter Your First Name: ");
		firstName = input.nextLine();

		System.out.print("Please Enter Your Middle Name: ");
		middleName = input.nextLine();

		System.out.print("Please Enter Your Last Name: ");
		lastName = input.nextLine();

		System.out.printf("%s%s%s",firstName.charAt(0),middleName.charAt(0),lastName.charAt(0));
	}

}


