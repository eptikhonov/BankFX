
public class problem5 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("This is not a long sentece");

		String[] words = sb.toString().split(" ");
		
		for (int i = words.length - 1; i >= 0; i--) {
			System.out.println(words[i]);
		}

	}

}
