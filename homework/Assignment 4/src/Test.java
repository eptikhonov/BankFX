import java.io.*;

class CreateData {                              
	
	// writing to oldmast.txt file
	public static void WriteToMast() throws IOException {
		int account;
		String name;
		double balance;
		PrintWriter oldmast = new PrintWriter(new FileWriter("oldmast.txt"), true);

		// Data for master file
		Object[][] data = {
				{100, "Alan Jones", 348.17},
				{300, "Mary Smith", 27.19},
				{500, "Sam Sharp", 0.00},
				{700, "Suzy Green", -14.22}
		};

		System.out.println("oldmast.txt:");
		for (Object item[] : data) {
			account = (int) item[0];
			name = (String) item[1];
			balance = (double) item[2];
			System.out.println(account + " " + name + " " + balance);
			oldmast.println(account + " " + name + " " + balance);
		}
	}

	// writing to trans.txt file
	public static void WriteToTrans() throws IOException {
		int account;
		double balance;
		PrintWriter trans = new PrintWriter(new FileWriter("trans.txt"), true);

		// Data for transaction file
		Object[][] data = {
				{100, 27.14},
				{300, 62.11},
				{400, 100.56},
				{900, 82.17}
		};
		
		System.out.printf("%ntrans.txt:%n");
		for (Object item[] : data) {
			account = (int) item[0];
			balance = (double) item[1];
			System.out.println(account + " " + balance);
			trans.println(account + " " + balance);
		}
	}
}

public class Test {
	public static void main(String[] args) throws IOException {
		CreateData.WriteToMast();
		CreateData.WriteToTrans();
		FileMatch.Match();
	}
}