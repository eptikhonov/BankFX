
public class BankAccount_Tester {

	public static void main(String[] args) {
		BankAccount myAccount = new BankAccount(2000.0);
		
		myAccount.withdraw(1000.0);
		myAccount.deposit(999.0);
		myAccount.withdraw(1000.0);
		
		System.out.printf("$%.2f\n",myAccount.getBalance());
		
		System.out.println(BankAccount.transactions());
		
		myAccount.withdraw(99.0);
		
		System.out.printf("$%.2f\n",myAccount.getBalance());
		
		System.out.println(BankAccount.transactions());
	}

}
