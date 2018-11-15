public class problem4 {

	public static String getLastFirst (String name) {
		int index = name.indexOf(' ');
		String lastNameFirst = name.substring(index + 1, name.length()) + ", " + name.substring(0, index);
		
		return lastNameFirst;
	}

	public static void main(String[] args) {
		System.out.println(getLastFirst("Jordan Smith"));
	}

}