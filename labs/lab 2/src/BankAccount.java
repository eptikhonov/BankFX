
public class BankAccount {

	private double balance;
	private static int transactions;

	public BankAccount(double balance) {
		
		// giving initial account bonus of $100
		this.balance = balance + 100.0;
	}

	public void deposit(double amount) {
		// check for negative deposit amounts
		if (amount < 0) {
			throw new IllegalArgumentException("Please enter a positive deposit amount");
		} else {
			balance += amount;
			transactions++;
		}
	}

	public void withdraw(double amount) {

		// check for negative withdraw amounts
		if (amount < 0) {
			throw new IllegalArgumentException("Please enter a positive withdraw amount");
		} else {
			// charge $1 more if balance is less than a thousand
			if (balance < 1000) amount += 1.0;

			balance -= amount;
			transactions++;
		}

	}
	public double getBalance() {
		return balance;
	}
	
	// getter method for number of transactions
	public static int transactions() {
		return transactions;
	}
	
}
