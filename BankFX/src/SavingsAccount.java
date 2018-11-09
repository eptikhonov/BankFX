
public class SavingsAccount extends BankAccount {

	private double interestRate;

	// constructor
	public SavingsAccount(String accountType, int accountID, double accountBalance, double interestRate) {
		super(accountType, accountID, accountBalance); // calling super class's constructor

		this.interestRate = interestRate;
	}


	public void computeInterest() {

		this.accountBalance += super.getBalance() * interestRate;
	}



}
