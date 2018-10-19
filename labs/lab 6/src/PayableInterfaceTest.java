// Fig. 10.14: PayableInterfaceTest.java
// Payable interface test program processing Invoices and 
// Employees polymorphically.
public class PayableInterfaceTest {
	public static void main(String[] args) {
		// create four-element Payable array
		Payable[] payableObjects = new Payable[] {
				new Invoice("01234", "seat", 2, 375.00),
				new Invoice("56789", "tire", 4, 79.95),
				new SalariedEmployee("John", "Smith", "111-11-1111", 800.00),
				new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40.0),
				new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, 0.06),
				new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, 0.04, 300)
		};

		System.out.println(
				"Invoices and Employees processed polymorphically:"); 

		// generically process each element in array payableObjects
		for (Payable currentPayable : payableObjects) {

			System.out.printf("%n%s%n",currentPayable.toString());
			if (currentPayable instanceof BasePlusCommissionEmployee) {
				// increase base salary by 10%
				double newSalary = ((BasePlusCommissionEmployee) currentPayable).getBaseSalary() * 1.1;
				System.out.println("new base salary with 10% increase is: "+newSalary);
				
				((BasePlusCommissionEmployee) currentPayable).setBaseSalary((newSalary));
				
				System.out.printf("payment due: $%.2f%n", currentPayable.getPaymentAmount());
			}else {
				// output currentPayable and its appropriate payment amount
				System.out.printf("payment due: $%.2f%n", currentPayable.getPaymentAmount());
			}

		} 
	} 
} 


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
