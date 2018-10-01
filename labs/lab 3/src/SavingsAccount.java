
public class SavingsAccount extends BankAccount {

	private double interestRate;
	
	// constructor
	public SavingsAccount(String name, double balance, double interestRate) {
		super(name, balance); // calling super class's constructor
		
		this.interestRate = interestRate;
	}
	
	
	public void computeInterest() {
		
		this.balance += super.getBalance() * interestRate;
	}
	
	

}
