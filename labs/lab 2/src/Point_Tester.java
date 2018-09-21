
public class Point_Tester {

	public static void main(String[] args) {
		Point point1 = new Point(8, 2);
		Point point2 = new Point(4, 3);
		
		
		System.out.printf("Point1 distance from origin: %.2f\n",Point.distanceFromOrigin(point1));
		System.out.printf("Distance between two points: %.2f\n",point1.distance(point2));
		
		point2.translate(2, 3);
		System.out.println("Point2: "+point2.toString());
		
		System.out.printf("Distance between two points: %.2f\n", point1.distance(point2));
		
		point1.translate(6, -2);
		System.out.println("Point1: "+point1.toString());

		
		System.out.printf("Distance between two points: "+point1.distance(point2));

	}

}
