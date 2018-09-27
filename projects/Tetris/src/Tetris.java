import javafx.geometry.Point2D;
import javafx.scene.Node;

public class Tetris {
	/*
	private int[][] L = { {0, 1, 0},
						  {0, 1, 0},
						  {0, 1, 1} };

	private int[][] J = { {0, 1, 0},
						  {0, 1, 0}, 
						  {1, 1, 0} };

	private int[][] S = { {0, 1, 1},
			  			  {1, 1, 0}, 
			  			  {0, 0, 0} };

	private int[][] Z = { {1, 1, 0}, 
						  {0, 1, 1}, 
						  {0, 0, 0} };

	private int[][] T = { {0, 0, 0},
						  {1, 1, 1}, 
						  {0, 1, 0} };

	private int[][] I = { {0, 1, 0, 0},
						  {0, 1, 0, 0}, 
						  {0, 1, 0, 0}, 
						  {0, 1, 0, 0} };

	private int[][] O = { {1, 1},
						  {1, 1} };
	 */
	// private static int[][] shapes; 

	private Node view;
	private Point2D velocity = new Point2D(0,0);

	public Tetris(Node view) {
		this.view = view;
		//Tetris.coloringShapes(L);
	}
	
	public double getRotate() {
		return view.getRotate();
	}
	
	public void rotate() {
		view.setRotate(view.getRotate() + 10);
		setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate() * 90)), Math.sin(Math.toRadians(getRotate()) * 90)));
	}
	
	public void moveLeft() {
		view.setTranslateX(view.getTranslateX() - 10);
		
	}
	
	public void moveRight() {
		view.setTranslateX(view.getTranslateX() + 10);
		
	}
	
	public void update() {
		view.setTranslateX(view.getTranslateX() + velocity.getX());
		view.setTranslateY(view.getTranslateY() + velocity.getY());
	}

	public void setVelocity(Point2D velocity) {
		this.velocity = velocity;
	}
	
	// display
	public Node getView() {
		return view;
	}
	
	public Point2D getVelocity() {
		return velocity;
	}

}

