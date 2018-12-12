import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileMatch {
	
	// reading oldmast and trans and putting matching stuff into newmast
	public static void Match() throws IOException {
		PrintWriter newmast = new PrintWriter(new FileWriter("newmast.txt"),true);
		PrintWriter log = new PrintWriter(new FileWriter("log.txt"),true);
		BufferedReader transReader = new BufferedReader(new InputStreamReader(new FileInputStream("trans.txt")));
		BufferedReader accountReader = new BufferedReader(new InputStreamReader(new FileInputStream("oldmast.txt")));
		Account account = new Account();
		TransactionRecord tr = new TransactionRecord();

		String accountLine;
		String firstName, lastName;
		
		// reading in oldmast file
		while((accountLine = accountReader.readLine()) != null) {
			Object[] splitAccount = accountLine.split(" ");
			
			firstName = (String) splitAccount[1];
			lastName = (String) splitAccount[2];
			account.setAccount(Integer.parseInt((String) splitAccount[0]));
			account.setBalance(Double.parseDouble((String) splitAccount[3]));
			
			String trans_line;
			int accountNumber = 0;
			
			// reading in trans file and adding matches to newmast.txt
			while((trans_line = transReader.readLine()) != null){
				Object[] splitTransaction = trans_line.split(" ");
				accountNumber = Integer.parseInt((String) splitTransaction[0]);
				double transaction = Double.parseDouble((String) splitTransaction[1]);
				tr.setAccountNumber(accountNumber);
				tr.setAmount(transaction);
				if(accountNumber == account.getAccount()) {
					System.out.printf("%nMatch found! Account %d's balance has been increased by %.2f.%n", accountNumber, transaction);
					System.out.println("New account balance is " + account.combine(tr));
					System.out.println("Saving new data to 'newmast.txt'\n");
					newmast.println(account.getAccount() + " " + firstName + " " + lastName + " " + account.combine(tr));
					break;
				}
				
				// if trans account num is not in mast, put into log.txt
				if (accountNumber != account.getAccount()) {
					System.out.println("Added to log.txt: Unmatched transaction record for account number " + accountNumber);
					log.println("Unmatched transaction record for account number " + accountNumber);
				}
			}
		}
		
		newmast.close();
		log.close();
		transReader.close();
		accountReader.close();

	}
}