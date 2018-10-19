
public class Square extends Quadrilateral {
	
	// constructor
	public Square(Point bottomLeft, Point bottomRight, Point topRight, Point topLeft) {
		super(bottomLeft, bottomRight, topRight, topLeft);
	}
	
	private double getSide() {
		return Math.abs(topLeft.getY() - bottomLeft.getY());
	}
	
	@Override
	public double getArea() {
		return Math.pow(getSide(), 2);
	}

	@Override
	public String toString() {
		super.toString();
		System.out.println("Side is: " + getSide());
		System.out.printf("Area is: %.1f\n\n", getArea());
		return "";
	}
	
}
