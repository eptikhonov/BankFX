
public class BankAccount {

	protected double balance;
	protected String name;

	public BankAccount(String name, double balance) {
		
		this.name = name;
		this.balance = balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {

		balance -= amount;
	}
	public double getBalance() {
		return balance;
	}
	
	public void transfer(BankAccount otherAccount, double amount) {
		
		// check for negative transfer amounts
		if (amount < 0) {
			throw new IllegalArgumentException("Please enter a positive transfer amount");
		} else {
			balance -= amount;
			otherAccount.deposit(amount);
		}
		
	}
	
}
