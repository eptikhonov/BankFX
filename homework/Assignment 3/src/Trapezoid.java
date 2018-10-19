
public class Trapezoid extends Quadrilateral {
	
	// empty constructor
	public void Trapezoid() {
		
	}
	
	public Trapezoid(Point bottomLeft, Point bottomRight, Point topRight, Point topLeft) {
		super(bottomLeft, bottomRight, topRight, topLeft);
	}
	
	private double getHeight() {
		double bottomBase = Math.abs(bottomRight.getX() - bottomLeft.getX());
		double topBase = Math.abs(topRight.getX() - topLeft.getX());
		return Math.round(2 * (getArea()/(topBase+bottomBase)));
	}
	
	@Override
	public double getArea() {
		
		double a = Math.abs(bottomLeft.getX() - bottomRight.getX());
		double c = Math.abs(topLeft.getX() - topRight.getX());
		double b = Math.abs(topLeft.getY() - bottomLeft.getY());
		double d = Math.abs(topRight.getY() - bottomRight.getY());
		return ((a+c) / 2) * Math.sqrt(Math.pow(b, 2) - Math.pow((( Math.pow(b, 2) - Math.pow(d, 2)+(Math.pow(a-c, 2)))/ (2*a*c)  ),2) ) ;
	}
	
	@Override
	public String toString() {
		super.toString();
		System.out.println("Height is: " + getHeight());
		System.out.printf("Area is: %.2f\n\n", getArea());
		return "";
	}
	
}
