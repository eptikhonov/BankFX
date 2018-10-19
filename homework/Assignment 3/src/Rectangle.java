
public class Rectangle extends Quadrilateral {
	
	// constructor
	public Rectangle(Point bottomLeft, Point bottomRight, Point topRight, Point topLeft) {
		super(bottomLeft, bottomRight, topRight, topLeft);
	}
	
	public double getHeight() {
		return Math.abs(topLeft.getY() - bottomLeft.getY());
	}
	
	public double getWidth() {
		
		return Math.abs(topLeft.getX() - topRight.getX());
	}
	
	@Override
	public double getArea() {
		return getWidth() * getHeight();
	}
	
	@Override
	public String toString() {
		super.toString();
		System.out.println("Width is: " + getWidth());
		System.out.println("Height is: " + getHeight());
		System.out.printf("Area is: %.1f\n\n", getArea());
		return "";
	}
}
