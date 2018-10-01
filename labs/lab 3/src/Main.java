
public class Main {

	public static void main(String[] args) {
		
		// creating two savings accounts
		SavingsAccount firstAccount = new SavingsAccount("Eric", 2000, 0.05);
		SavingsAccount secondAccount = new SavingsAccount("Vishal", 200, 0.05);
		
		// withdrawing 500 dollars from firstAccount to secondAccount
		firstAccount.transfer(secondAccount, 500.00);
		
		// printing balances
		System.out.printf("Frist Account Balance: $%.2f\n", firstAccount.getBalance());
		System.out.printf("Second Account Balance: $%.2f\n", secondAccount.getBalance());
		
		// computing interest
		firstAccount.computeInterest();
		secondAccount.computeInterest();
		
		System.out.println();
		
		// printing balances
		System.out.printf("Frist Account Balance: $%.2f\n", firstAccount.getBalance());
		System.out.printf("Second Account Balance: $%.2f\n", secondAccount.getBalance());
		
		

	}

}
