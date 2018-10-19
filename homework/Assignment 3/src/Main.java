
public class Main {

	public static void main(String[] args) {
		Quadrilateral qdr = new Quadrilateral(new Point(2.2, 7.4),new Point(6.2, 9.9),new Point(1.1, 1.2),new Point(6.6, 2.8));
		qdr.toString();
		System.out.println();
		
		Trapezoid trp = new Trapezoid(new Point(3.3, 5.0),new Point(8.0, 5.0),new Point(0.0, 0.0),new Point(10.0, 0.0));
		trp.toString();
		
		Parallelogram prl = new Parallelogram(new Point(6.0, 20.0),new Point(12.0, 20.0),new Point(5.0, 5.0),new Point(11.0, 5.0));
		prl.toString();
		
		Rectangle rct = new Rectangle(new Point(17.0, 28.0), new Point(30.0, 28.0), new Point(17.0, 14.0), new Point(30.0, 14.0));
		rct.toString();
		
		Square sqr = new Square(new Point(4.0, 4.0),new Point(8.0, 4.0),new Point(4.0, 0.0),new Point(8.0, 0.0));
		sqr.toString();
		
	}

}

