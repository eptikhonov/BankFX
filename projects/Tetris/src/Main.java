import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

	private Pane root;   // root node
	
	private List<Tetris> shapes = new ArrayList<>();
	
	private Tetris player;
	
	private Parent createContent() {
		root = new Pane();
		root.setPrefSize(400, 600);
		
		player = new Player();
		player.setVelocity(new Point2D(1, 0));
		
		addShapeObject(player, 200, 150);
		
		AnimationTimer timer = new AnimationTimer() {
		
			// the main game loop
			@Override
			public void handle(long now) {
				onUpdate();
			}
		
		};
		timer.start();
		
		return root;
	}
	
	// add shape to list of shapes
	private void addShape (Tetris shape, double x, double y) {
		shapes.add(shape);
		addShapeObject(shape, x, y);
	}
	
	// add shape to scene
	private void addShapeObject (Tetris shape, double x, double y) {
		shape.getView().setTranslateX(x);
		shape.getView().setTranslateY(y);
		root.getChildren().add(shape.getView());
	}
	
	// check if row is made, score, background, colors, shapes
	private void onUpdate() {
		
		// create random shapes from list
		// if object is put down, create another randomly using Math.random()
		//addShape(new Shapes(/*random*/), 200, 150);
	}
	
	private static class Player extends Tetris {
		Player() {
			super(new Rectangle(40, 20, Color.BLUE));
		}
	}
	
	private static class Shapes extends Tetris {
		Shapes() {
			super(new Rectangle(40, 20, Color.BLUE));
		}
	}
	
	
    @Override
    public void start(Stage stage) throws Exception {
    	
    	stage.setScene(new Scene(createContent()));
    	stage.show();
    	
    	stage.getScene().setOnKeyPressed(e -> {
    		if (e.getCode() == KeyCode.DOWN) {
    			// speed up down motion
    		} else if (e.getCode() == KeyCode.UP) {
    			// rotate right
    			player.rotate();
    		} else if (e.getCode() == KeyCode.RIGHT) {
    			// move right
    			player.moveRight();
    		} else if (e.getCode() == KeyCode.LEFT) {
    			// move left
    			player.moveLeft();
    		}
    		
    	});
    }

    public static void main(String[] args) {
    	
        // starts FX application
        launch(args); 
        
    }
}