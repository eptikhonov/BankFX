
public class PieceWorker extends Employee {

	private double wage;
	private int pieces;
	
	public PieceWorker(String firstName, String lastName, String socialSecurityNumber, double wage, int pieces) {
		super(firstName, lastName, socialSecurityNumber);
		
		if (wage < 0.0) { // validate wage                  
	         throw new IllegalArgumentException("Wage must be > 0.0");
	      } else if (pieces < 0.0) { // validate pieces
	    	 throw new IllegalArgumentException("Pieces must be > 0.0");
	      }   
	             
	      this.wage = wage;
	      this.pieces = pieces; 

	}
	
		// set wage amount
	   public void setWage(double wage) {
	      if (wage < 0.0) { // validate
	         throw new IllegalArgumentException("Wage must be > 0.0");
	      }

	      this.wage = wage;
	   } 

	   // return wage amount
	   public double getWage() {return wage;}

	   // set pieces
	   public void setPieces(int pieces) {
	      if (pieces < 0) { // validate
	         throw new IllegalArgumentException(
	        		 "Pieces must be > 0");
	      }

	      this.pieces = pieces;
	   } 

	   // return pieces
	   public double getPieces() {return pieces;}

	   
	   @Override                                                           
	   public double earnings() {                                          
	      return getPieces() * getWage();                    
	   }
	   
	   @Override                                                   
	   public String toString() {                                  
	      return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",     
	         "pieceworker employee", super.toString(),              
	         "wage", getWage(),                       
	         "pieces", getPieces());              
	   } 

}
