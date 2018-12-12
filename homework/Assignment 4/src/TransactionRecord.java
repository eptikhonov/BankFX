public class TransactionRecord {
	private int accountNumber;
	private double amount;

	// empty constructor
	public TransactionRecord() {

	};

	// constructor
	public TransactionRecord(int accountNumber, double amount) {
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	// set account number
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	// get account number
	public int getAccountNumber() { return accountNumber; }

	// set amount
	public void setAmount(double amount) {
		this.amount = amount;
	}

	// get amount
	public double getAmount() { return amount;}
}