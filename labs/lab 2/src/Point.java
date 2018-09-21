
public class Point {

	private int x;
	private int y;
	
		// no values provided
		public Point() {
			x = 15;
			y = 15;
		}
		
		// both values provided
		public Point(int x, int y) {
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
		
		public void translate(int dx, int dy) {
			this.x += dx;
			this.y += dy;
			
		}
		
		// printing position of point
		public String toString() {
			
			return "(" + this.x + ", " + this.y + ")";
		}
 }
