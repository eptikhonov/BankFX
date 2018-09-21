import java.util.Scanner;

public class score {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int[] scores = new int[5];
		int counter = 0;
		int inputScore = 0;
		int totalNumOfPasses = 0;
		int totalNumOfFailures = 0;
		int highestScore = 0;
		int lowestScore = 0;

		// adding 5 scores into an array
		while (counter < 5) {
			inputScore = input.nextInt();

			// if input is not from 0 to 100, inform user. Else, add to array
			if (inputScore > 100 || inputScore < 0) {
				System.out.println("Invalid Score");
				inputScore = input.nextInt();

			} else {
				scores[counter] = inputScore;
			}
			counter++;

			// assigning highest and lowest scores
			if (highestScore < inputScore) highestScore = inputScore;
			lowestScore = inputScore;
		}

		input.close();

		// printing out scores
		System.out.println();
		for (int score: scores) {
			// check if pass or fail
			if (score >= 60) {
				System.out.println(score+": Pass");
				totalNumOfPasses++;
			} else {
				System.out.println(score+": Fail");
				totalNumOfFailures++;
			}
			// assigning lowest scores
			if (lowestScore > score) lowestScore = score;
		}

		// printing out extra information
		System.out.println("\nTotal number of passes: "+totalNumOfPasses);
		System.out.println("Total number of failures: "+totalNumOfFailures);

		System.out.println("\nHighest score: "+highestScore);
		System.out.println("Lowest score: "+lowestScore);
	}

}
