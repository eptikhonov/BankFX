
public class Point {

	private double x;
	private double y;
	
		// no values provided
		public Point() {
			x = 15;
			y = 15;
		}
		
		// both values provided
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		// point object is provided
		public Point(Point obj) {
			this.x = obj.x;
			this.y = obj.y;
		}
		
		public static double distanceFromOrigin(Point obj) {
			
	        return Math.sqrt(Math.pow(obj.x - 0, 2) + Math.pow(obj.y - 0, 2));
		}
		
		// using Euclidean calculation
		public double distance(Point obj) {
			
			double dx = this.x - obj.x;
	        double dy = this.y - obj.y;
	        
	        return Math.sqrt(dx * dx + dy * dy);
			
		}
		
		public void translate(double dx, double dy) {
			this.x += dx;
			this.y += dy;
			
		}
		
		public void setX(double x) {
			this.x = x;
		}
		
		public double getX() {
			return x;
		}
		
		public void setY(double y) {
			this.y = y;
		}
		
		public double getY() {
			return y;
		}
		
		// printing position of point
		public String toString() {
			
			return "(" + this.x + ", " + this.y + ")";
		}
 }
