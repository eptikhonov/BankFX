
public class Quadrilateral {
		
	protected Point topLeft;
	protected Point topRight;
	protected Point bottomLeft;
	protected Point bottomRight;
	
	private double area;
	
	// empty constructor
	public void Quadrilateral() {

	}
	
	public Quadrilateral(Point bottomLeft, Point bottomRight, Point topRight, Point topLeft) {
		this.bottomLeft = bottomLeft;
		this.bottomRight = bottomRight;
		this.topRight = topRight;
		this.topLeft = topLeft;
		
	}
	
	public void setArea(double area) {
		this.area = area;
	}
	
	public double getArea() {
		return area;
	}

	@Override
	public String toString() {
		System.out.println("Coordinates of "+this.getClass().getSimpleName()+" are:");
		System.out.println(topRight.toString() + ", " + topLeft.toString() + ", " + bottomRight.toString() + ", " + bottomLeft.toString());
		return "";
	}
}
