
public class Parallelogram extends Quadrilateral {

	// empty constructor
	public void Parallelogram() {

	}

	public Parallelogram(Point bottomLeft, Point bottomRight, Point topRight, Point topLeft) {
		super(bottomLeft, bottomRight, topRight, topLeft);

	}

	public double getWidth() {
		return Math.sqrt( Math.pow(topRight.getX() - topLeft.getX(), 2) + Math.pow(topRight.getY() - topLeft.getY(), 2));
	}


	public double getHeight() {
		double height = Math.round(Math.sqrt( Math.pow(topRight.getX() - bottomLeft.getX(), 2) + Math.pow(topRight.getY() - bottomLeft.getY(), 2)));
		return height;
	}


	@Override
	public double getArea() {
		return getWidth() * getHeight();
	}

	@Override
	public String toString() {
		super.toString();
		System.out.println("Width is: " + this.getWidth());
		System.out.println("Height is: " + this.getHeight());
		System.out.printf("Area is: %.1f\n\n", getArea());
		return "";
	}
}
